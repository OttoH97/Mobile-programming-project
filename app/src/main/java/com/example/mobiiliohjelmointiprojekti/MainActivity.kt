package com.example.mobiiliohjelmointiprojekti

import android.os.Bundle
import android.util.Log.d
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_lisaa_arvostelu.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home -> {
                d("oeh", "You clicked Home")
                Navigation.findNavController(fragmentContainerView)
                    .navigate(R.id.action_global_paaikkuna3)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



}