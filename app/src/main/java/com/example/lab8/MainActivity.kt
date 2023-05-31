package com.example.lab8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val carData = listOf(
            Pair("BMW","https://wiki.cuspu.edu.ua/images/thumb/e/ee/BMW.png/300px-BMW.png"),
            Pair("Mercedes-Benz" ,"https://wiki.cuspu.edu.ua/images/thumb/1/1f/Mercedes-benz.jpg/280px-Mercedes-benz.jpg"),
            Pair("Nissan","https://wiki.cuspu.edu.ua/images/thumb/7/75/Nissan.jpg/300px-Nissan.jpg"),
            Pair("Toyota","https://wiki.cuspu.edu.ua/images/thumb/2/23/Toyota.jpg/300px-Toyota.jpg"),
            Pair("Kia" , "https://wiki.cuspu.edu.ua/images/thumb/f/f6/Kia.jpg/300px-Kia.jpg"),
            Pair("Ford" , "https://wiki.cuspu.edu.ua/images/thumb/5/5e/Ford.jpg/300px-Ford.jpg"),
            Pair("Renault","https://wiki.cuspu.edu.ua/images/thumb/6/6a/Renault.png/280px-Renault.png"),
            Pair("Hyundai","https://wiki.cuspu.edu.ua/images/thumb/e/ec/Hyundai.png/250px-Hyundai.png"),
            Pair("Mazda" , "https://wiki.cuspu.edu.ua/images/thumb/7/70/Mazda.jpg/200px-Mazda.jpg"),
            Pair("Audi" , "https://wiki.cuspu.edu.ua/images/thumb/3/34/Audi.jpg/280px-Audi.jpg")
        )
        val adapter = CarAdapter(carData){ position ->
            Toast.makeText(this,carData[position].first,Toast.LENGTH_SHORT).show()
        }
        binding.recyclerView.adapter = adapter

    }
}