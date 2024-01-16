package com.staszek15.bucketlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager.getDefaultSharedPreferences
import com.staszek15.bucketlist.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val sharedPref by lazy { getDefaultSharedPreferences(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.cardViewThingsToDo.setOnClickListener { openBucketList("things") }
        binding.cardViewPlacesToGo.setOnClickListener { openBucketList("places") }
    }

    private fun openBucketList(listType: String) {
        val intent = Intent(this, BucketListActivity()::class.java)
        sharedPref.edit().putString("listType", listType).apply()
        startActivity(intent)
    }


}