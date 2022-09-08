package com.example.mysolarsystem

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*

class Adapter(private var planet: List<PlanetData>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.title
        var planetimg = view.planet_img
        var galaxy = view.galaxy
        var distance = view.distance
        var gravity = view.gravity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = planet[position]

        //An Intent is a messaging object you can use to request an action from another app component.
        // Although intents facilitate communication between components in several ways, there are three fundamental use cases:
        // Starting an activity.

        //Intents are asynchronous messages which allow Android components to request functionality from other components of the Android system.
        // For example an Activity can send an Intents to the Android system which starts another Activity .
        // putExtra() adds extended data to the intent.
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,PlanetDetail::class.java)
            intent.putExtra("planet", data)
            intent.putExtra("planetImage", data.planetResourceID)
            holder.itemView.context.startActivity(intent)
        }

        holder.title.text = data.title
        holder.galaxy.text = data.galaxy
        holder.distance.text = String.format("%.2f km", data.distance)
        holder.gravity.text = String.format("%.2f m/s", data.gravity)
        holder.planetimg.setImageResource(data.planetResourceID)
    }

    override fun getItemCount(): Int {
        return planet.size
    }
}

