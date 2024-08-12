package com.example.bookstore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bookstore.R.*

class BookAdapter(val data :List<Books>): ListAdapter<Books, BookAdapter.MyViewHolder>(UserItemDiffCallback())  {
    class MyViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val tvName = row.findViewById<TextView>(id.tv_name)
        val tvAuthor= row.findViewById<TextView>(id.tv_Author)
        val BookImage = row.findViewById<ImageView>(id.iv_BookImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_book,
            parent, false)
        return BookAdapter.MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text = data.get(position).name
        holder.tvAuthor.text = data.get(position).author
        holder.BookImage.setImageResource(data.get(position).image)  // Set the image using the resource ID
    }
    override fun getItemCount(): Int {
        return data.size
    }

}
class UserItemDiffCallback: DiffUtil.ItemCallback<Books>() {
    override fun areItemsTheSame(oldItem: Books, newItem: Books): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Books, newItem: Books): Boolean {
        return oldItem == newItem
    }

}