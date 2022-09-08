@file:Suppress("DEPRECATION")

package com.example.mysolarsystem

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_planet_detail.*
class PlanetDetail : AppCompatActivity() {

    //The lateinit keyword allows you to avoid initializing a property when an object is constructed.
    // If your property is referenced before being initialized, Kotlin throws an UninitializedPropertyAccessException ,
    // so be sure to initialize your property as soon as possible

    private lateinit var obj:PlanetData
    private var planetImg:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_detail)

        //Used this Syntax to automatically hide the Navigation and Trigger the App in Fullscreen
        window.decorView.apply { systemUiVisibility=
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN }

        //Retrieved data from Adapter thru Intent
        obj = intent.getParcelableExtra("planet")!!
        planetImg = obj.planetResourceID
        setData(obj, planetImg!!)
    }

    private fun setData(obj:PlanetData, planetImg:Int) {
        title_info.text = obj.title
        distance_info.text = String.format("%.2f km", obj.distance)
        gravity_info.text = String.format("%.2f m/s", obj.gravity)
        overview_info.text = obj.overview
        galaxy_info.text = obj.galaxy
        planet_img_info.setImageResource(planetImg)

    }
}