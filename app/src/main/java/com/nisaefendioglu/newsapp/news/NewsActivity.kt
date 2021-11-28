package com.nisaefendioglu.newsapp.news
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.nisaefendioglu.newsapp.R
import dagger.hilt.android.AndroidEntryPoint

import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //setup navigation controller
        setupNavController()
    }

    private fun setupNavController() {
        val navController = findNavController(R.id.navigation_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
        toolbar.setupWithNavController(navController)
    }
}
