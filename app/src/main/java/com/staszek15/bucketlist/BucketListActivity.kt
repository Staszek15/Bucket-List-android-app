package com.staszek15.bucketlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.staszek15.bucketlist.databinding.ActivityBucketListBinding

class BucketListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBucketListBinding
    private val listType by lazy { intent.getStringExtra("listType")!! }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBucketListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createRecyclerView()
        fab()
    }

    private fun fab() {
        binding.fab.setOnClickListener {
            val intent = Intent(this, AddItemActivity()::class.java)
            startActivity(intent)
        }
    }

    private fun createBucketList(listType: String): List<BucketListItem> {
        if (listType == "things") {
            return buildList {
                add(BucketListItem("Scuba Diving", "Explore the deep with oxygen bottle. Admire the coral reef and all the beautiful creatures that live there.", R.drawable.scubadive, 4f))
                add(BucketListItem("World Cup", "Experience a thrilling football world cup final.", R.drawable.mundial, 4.5f))
                add(BucketListItem("Dolphins", "Swim with playful dolphins in a beautiful place.", R.drawable.dolphins, 4f))
                add(BucketListItem("Northern Lights", "Spend a peaceful evening watching staggering northern lights from a hot tub.", R.drawable.northern_lights, 4f))
                add(BucketListItem("Dream house", "Buy a luxury mansion for my family.", R.drawable.dreamhouse, 5f))
                add(BucketListItem("Android", "Become an android developer. Let my work be a pleasure.", R.drawable.androiddev, 4.75f))
                add(BucketListItem("French", "Learn to speak French fluently.", R.drawable.french, 3.5f))
            }
        } else {
            return buildList {
                add(BucketListItem("Amazon", "Embark on a journey through thick amazon forest. See all the wild animals and flowers.", R.drawable.amazon, 5f))
                add(BucketListItem("Maldives", "Spend the best holiday in my life in a luxury lodge surrounded by turquoise water.", R.drawable.maldives, 5f))
                add(BucketListItem("Switzerland", "Go for a hike in one of the most beautiful places on Earth. Enjoy the icy summits and bright green meadows.", R.drawable.switzerland, 4.5f))
                add(BucketListItem("Singapore", "Visit a completely different type of country.", R.drawable.singapore, 3f))
                add(BucketListItem("Faro", "Sunbathe under colorful cliffs on Praia da Falesia.", R.drawable.falesia, 3f))
                add(BucketListItem("Santorini", "Take a walk through a distinctive romantic city.", R.drawable.santorini, 3f))
                add(BucketListItem("Grand Canyon Park", "See one of the biggest nature miracles.", R.drawable.canyon, 3.5f))
            }
        }
    }

    private fun createRecyclerView() {
        val adapter = BucketListAdapter(createBucketList(listType))
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.adapter = adapter
    }

}