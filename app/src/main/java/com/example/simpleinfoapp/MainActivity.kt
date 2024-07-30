// MainActivity.kt
package com.example.simpleinfoapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val buttonShowFragment: Button = findViewById(R.id.buttonShowFragment)
        buttonShowFragment.setOnClickListener {
            showFragment(InfoFragment())
        }
    }

    private fun showSettings() {
        // Create and show a new fragment or activity for Settings
        val settingsFragment = SettingsFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, settingsFragment)
            .addToBackStack(null)
            .commit()
    }
    private fun showAboutUs() {
        // Create and show a new fragment or activity for About Us
        val aboutFragment = AboutFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, aboutFragment)
            .addToBackStack(null)
            .commit()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                // Replace with SettingsFragment
                replaceFragment(SettingsFragment())
                true
            }
            R.id.action_about -> {
                // Replace with AboutFragment
                replaceFragment(AboutFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment) // Replace with your container ID
            .addToBackStack(null) // Optional: Adds the transaction to the back stack
            .commit()
    }

    private fun showFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
