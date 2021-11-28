package com.nisaefendioglu.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setupNavController()
    }

    private fun setupNavController() {
        val navController = findNavController(R.id.navigation_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
        toolbar.setupWithNavController(navController)
    }
}
