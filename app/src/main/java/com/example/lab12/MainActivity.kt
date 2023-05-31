package com.example.lab12

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lab12.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.io.File
import java.io.FileWriter


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showPosts()

        binding.buttonSave.setOnClickListener {
            savePostsToFile(postsList)
        }
    }
    private val baseUrl  = "https://jsonplaceholder.typicode.com/"

     lateinit var postsList: ArrayList<Posts>

    fun showPosts(){
        val interceptor = CustomInterceptor()

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        val retrofitAPI= retrofit.create(RetrofitAPI::class.java)

        val call : Call<List<Posts>> = retrofitAPI.getAllPosts()

        call.enqueue(object : Callback<List<Posts>> {
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                if(!response.isSuccessful){
                    binding.textView3.text = "error"
                    binding.textView4.text = "error"
                    binding.textView5.text = "error"
                    binding.textView6.text = "error"
                }
                postsList = response.body() as ArrayList<Posts>
                binding.textView3.text = postsList[0].user.toString()
                binding.textView4.text = postsList[0].Id.toString()
                binding.textView5.text = postsList[0].title
                binding.textView6.text = postsList[0].subtitle

            }



            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(applicationContext , "help111" , Toast.LENGTH_LONG).show()
            }
        })
    }
    private fun savePostsToFile(posts: List<Posts>) {
        val gson = Gson()
        val json = gson.toJson(posts)

        val fileName = "posts.json"
        val file = File(filesDir, fileName)

        try {
            val fileWriter = FileWriter(file)
            fileWriter.write(json)
            fileWriter.close()
            Toast.makeText(applicationContext, "Data saved to file", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}
