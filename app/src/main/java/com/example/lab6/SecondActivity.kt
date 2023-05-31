package com.example.lab6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab6.databinding.ActivityMainBinding
import com.example.lab6.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener{
            startActivity(Intent(this,ThirdActivity::class.java))
        }

        binding.button2.setOnClickListener{
            val data = binding.editTextText.text.toString().split(" ")
            val userData = User(data[0] , data[1].toInt() )
            val emailData = binding.editTextTextEmailAddress.text.toString()
            val phoneData = binding.editTextPhone.text.toString()


            startActivity(Intent(this,ThirdActivity::class.java).apply {
                putExtra("userData" , userData)
                putExtra("quantity" , 1)
                putExtra("emailData" , emailData)
                putExtra("phoneData" , phoneData)
            })

        }

    }
}