package com.example.lab10

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.lab10.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Room.databaseBuilder(
            applicationContext,
            UserDB::class.java,"database-name"

        ).build()
        val userDao = db.userDao()
        binding.buttonSave.setOnClickListener{
            val data = binding.fieldName.text
            val userInfo = data.split(' ')
            val user = User(firstName = userInfo[0] , lastName = userInfo[1] , age = userInfo[2].toInt())
            GlobalScope.launch {
                userDao.insertAll(user)
            }
            Toast.makeText(
                applicationContext,
                "User info saved",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.buttonRead.setOnClickListener{
            GlobalScope.launch {
                val users = userDao.getAll()
                var usersInfo = ""
                users.forEach {
                    usersInfo +="${it.firstName} ${it.lastName} ${it.age} \n"
                }
                runOnUiThread {
                    binding.textView.text = usersInfo
                }
            }
        }

    }

}