package com.nisaefendioglu.newsapp.di
import com.nisaefendioglu.newsapp.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {
    
    const val INTERCEPTOR_COMMON: String = "interceptor_common"
    const val INTERCEPTOR_LOGGING: String = "interceptor_logging"

    const val API_KEY = "e030bf7052314b9db62d89c0565dfe09"
    const val BASE_URL = "https://newsapi.org/v2/"

    const val FIRST_PAGE = 1
    const val ITEM_PER_PAGE = 15
    const val COUNTRY = "in"

    @Singleton
    @Provides
    fun provideAPIClient(
        okHttpClient: OkHttpClient
    ): ApiService {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideOkhttpClient(
        @Named(INTERCEPTOR_COMMON) commonInterceptor: Interceptor,
        @Named(INTERCEPTOR_LOGGING) loggingInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(commonInterceptor)
            .addInterceptor(loggingInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    @Named(INTERCEPTOR_COMMON)
    fun provideCommonInterceptor(): Interceptor {
        return object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val url = chain.request()
                    .url
                    .newBuilder()
                    .addQueryParameter("apiKey", API_KEY)
                    .addQueryParameter("country", COUNTRY)
                    .addQueryParameter("pageSize", "$ITEM_PER_PAGE")
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return chain.proceed(request)
            }
        }
    }

    @Singleton
    @Provides
    @Named(INTERCEPTOR_LOGGING)
    fun provideLoggingInterceptor(): Interceptor {
        return object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val request: Request = chain.request()
                Timber.tag("Okhttp_request").d(request.toString())

                val response = chain.proceed(request)
                val rawJson = response.body!!.string()

                Timber.tag("Okhttp_response").d(rawJson)

                return response.newBuilder()
                    .body(rawJson.toResponseBody(response.body!!.contentType())).build()
            }
        }
    }


}