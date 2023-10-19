package com.staszek15.bucketlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.staszek15.bucketlist.databinding.BucketListItemBinding

class BucketListAdapter(private val bucketListItems: List<BucketListItem>):
    RecyclerView.Adapter<BucketListAdapter.MyViewHolder>() {

    inner class MyViewHolder(binding: BucketListItemBinding): ViewHolder(binding.root) {
        val heading = binding.textViewHeading
        val description = binding.textViewDescription
        val image = binding.imageViewItem
        val rating = binding.ratingBar
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val bucketListItemBinding = BucketListItemBinding.inflate(inflater, parent, false)
        return MyViewHolder(bucketListItemBinding)
    }

    override fun getItemCount(): Int {
        return bucketListItems.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.heading.text = bucketListItems[position].heading
        holder.description.text = bucketListItems[position].description
        holder.image.setImageResource(bucketListItems[position].image)
        holder.rating.rating = bucketListItems[position].rating
    }

}