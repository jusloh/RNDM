/*
 * Created by Justin Loh on 28/6/19 4:12 PM
 * Last modifiled 28/6/19 4:12 PM.
 * Copyright (c) 2019. All rights reserved.
 */

package com.jusloh.rndm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ThoughtsAdapter(val thoughts: ArrayList<Thought>) : RecyclerView.Adapter<ThoughtsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.thought_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return thoughts.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.bindThought(thoughts[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val username = itemView?.findViewById<TextView>(R.id.listViewUsername)
        val timestamp = itemView?.findViewById<TextView>(R.id.listViewTimestamp)
        val thoughtTxt = itemView?.findViewById<TextView>(R.id.listViewThoughtTxt)
        val numLikes = itemView?.findViewById<TextView>(R.id.listViewNumLikesLbl)
        val likesImage = itemView?.findViewById<TextView>(R.id.listViewLikesImage)

        fun bindThought(thought: Thought) {

            username?.text = thought.username
            thoughtTxt?.text = thought.thoughtTxt
            numLikes?.text = thought.numLikes.toString()

            val dateFormatter = SimpleDateFormat("MMM d, h:mm a", Locale.getDefault())
            val dateString = dateFormatter.format(thought.timestamp)
            timestamp?.text = dateString
        }
    }
}