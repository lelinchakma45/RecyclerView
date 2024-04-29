package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val foods = ArrayList<FoodsData>()

        foods.add(FoodsData("Musfiqur Rahim", "He is Right handed batsman","", R.drawable.test))
        foods.add(FoodsData("Tamim Iqbal", "He is left handed batsman","", R.drawable.test))
        foods.add(FoodsData("Sakib Al Hasan", "He is a number 1 Allrounder","", R.drawable.test))
        foods.add(FoodsData("Mahmudullah Riyad", "He is Right handed batsman","", R.drawable.test))
        foods.add(FoodsData("Mashrafe Bin Mortaza", "He is Right handed bowler","", R.drawable.test))

        var myList = FoodAdapter(foods)
        binding.recyclerView.adapter = myList
        myList.onClick = {
            val foodClicked = it
            Toast.makeText(this, "Clicked " + foodClicked.foodName, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, FoodDetails::class.java)
            intent.putExtra("name", foodClicked.foodName)
            intent.putExtra("title", foodClicked.foodTitle)
            intent.putExtra("longDetails", foodClicked.foodLongDescription)
            intent.putExtra("image", foodClicked.foodImages)
            startActivity(intent)
        }

    }
}
