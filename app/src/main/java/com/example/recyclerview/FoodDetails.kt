package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import com.example.recyclerview.databinding.ActivityFoodDetailsBinding
import com.example.recyclerview.databinding.ActivityMainBinding

class FoodDetails : AppCompatActivity() {
    lateinit var binding: ActivityFoodDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFoodDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("title")
        val longdescription = intent.getStringExtra("longDetails")
        val imageResource = intent.getIntExtra("image", 0)

        binding.foodNameShow.text = name
        binding.foodTitleShow.text = description
        binding.foodLongDetailsShow.text = longdescription
        binding.foodImageShow.setImageResource(imageResource)
    }
}