package com.example.rojenjohn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.imageview.ShapeableImageView

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        //Look for view
        val titleDFHolder : TextView = view.findViewById(R.id.titleDF)
        val galaxyDFHolder : TextView = view.findViewById(R.id.galaxyDF)
        val linkDFHolder : TextView = view.findViewById(R.id.linkDF)
        val distanceDFHolder : TextView = view.findViewById(R.id.distanceDF)
        val gravityDFHolder : TextView = view.findViewById(R.id.gravityDF)
        val overviewDFHolder : TextView = view.findViewById(R.id.overviewDF)
        val imageDFHolder : ShapeableImageView = view.findViewById(R.id.imageDF)

        //Fetch data
        val args = this.arguments
        val planet = args?.getParcelable("planetItem") as PlanetDataClass?
        titleDFHolder.text = planet?.title
        galaxyDFHolder.text = planet?.galaxy
        linkDFHolder.text = planet?.link
        distanceDFHolder.text = planet?.distance.toString()
        gravityDFHolder.text = planet?.gravity.toString()
        overviewDFHolder.text = planet?.overview
        imageDFHolder.setImageResource(planet?.planetResourceID as Int)

        return view
    }
}