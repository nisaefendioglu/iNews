
package com.nisaefendioglu.newsapp.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.nisaefendioglu.newsapp.R
import com.nisaefendioglu.newsapp.base.BaseActivity
import com.nisaefendioglu.newsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    val mainViewModel: MainViewModel by viewModels()

    override fun onViewReady(savedInstanceState: Bundle?) {
        super.onViewReady(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "News App";
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    override fun setBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    private fun setupBottomNavigationBar() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.feedFragment,
                R.id.favoriteFragment
            )
        )
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    override fun onBackPressed() {
        super.onBackPressed();
    }
}