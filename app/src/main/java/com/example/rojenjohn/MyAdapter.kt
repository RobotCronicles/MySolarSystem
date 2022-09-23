package com.example.rojenjohn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class MyAdapter (private val planetsList : List<PlanetDataClass>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleHolder: TextView = itemView.planet_title
        var galaxyHolder: TextView = itemView.planet_galaxy
        var distanceHolder: TextView = itemView.planet_distance
        var gravityHolder: TextView = itemView.planet_gravity
        val imageHolder : ImageView = itemView.findViewById(R.id.planet_home_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val planetItem = planetsList[position]

        holder.titleHolder.text = planetItem.title
        holder.galaxyHolder.text = planetItem.galaxy
        holder.distanceHolder.text = String.format("%.2f km", planetItem.distance)
        holder.gravityHolder.text = String.format("%.2f m/s/s", planetItem.gravity)
        holder.imageHolder.setImageResource(planetItem.planetResourceID)

        holder.itemView.setOnClickListener { v ->
            val activity = v!!.context as AppCompatActivity
            val detailFragment = DetailFragment()
            val bundle = Bundle()

            bundle.putParcelable("planetItem", planetItem)
            detailFragment.arguments = bundle

            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, detailFragment).addToBackStack(null).commit()
        }
    }

    override fun getItemCount(): Int {
        return planetsList.size
    }



}