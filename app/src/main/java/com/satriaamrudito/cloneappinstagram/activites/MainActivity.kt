package com.satriaamrudito.cloneappinstagram.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.satriaamrudito.cloneappinstagram.R
import com.satriaamrudito.cloneappinstagram.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_nav.setOnNavigationItemSelectedListener(onBottomNavListener)

        val frag = supportFragmentManager.beginTransaction()
        frag.add(R.id.fragContainer, HomeFragment())
        frag.commit()
    }

    private val onBottomNavListener = BottomNavigationView.OnNavigationItemSelectedListener { i ->
        var selectedFragment: Fragment = HomeFragment()

        when(i.itemId) {
            R.id.bot_home -> {
                selectedFragment = HomeFragment()
            }
            R.id.bot_search -> {
                selectedFragment = SearchFragment()
            }
            R.id.bot_addpost -> {
                i.isChecked = false
                startActivity(Intent(this@MainActivity, AddPostActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }
            R.id.bot_like -> {
                selectedFragment = LikeFragment()
            }
            R.id.bot_Profile -> {
                selectedFragment = ProfileFragment()
            }
        }

        val frag = supportFragmentManager.beginTransaction()
        frag.replace(R.id.fragContainer, selectedFragment)
        frag.commit()

        true

    }
}
