package com.example.mobiiliohjelmointiprojekti

import android.os.Bundle
import android.util.Log.d
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.mobiiliohjelmointiprojekti.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MyStorage(var stored: String="") {
    fun setStoredString(storedStr: String) {
        stored=storedStr
    }
}

class MainActivity : AppCompatActivity() {

    lateinit var myStorage: MyStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myStorage = MyStorage()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.home -> {
                d("menuItem", "You clicked Home")
                Navigation.findNavController(fragmentContainerView).navigate(R.id.action_global_paaikkuna3)
                return true
            } else -> super.onOptionsItemSelected(item)
        }
    }

}