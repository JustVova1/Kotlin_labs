package com.example.lab6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lab6.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityThirdBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button3.setOnClickListener(){
            val intentUserData = intent.getParcelableExtra<User>("userData")
            val intentQuantity = intent.getIntExtra ("quantity",-1)
            val intentEmail = intent.getStringExtra("emailData")
            val intentPhone = intent.getStringExtra("phoneData")
            intentUserData.let {
                if(intentQuantity != -1){
                    if (it != null) {
                        binding.textView2.text = "Name: ${it.name} Age : ${it.age} "
                        binding.textView4.text = "Email: ${intentEmail} "
                        binding.textView5.text = "Phone: ${intentPhone} "
                    }
                }
            }
        }
   }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lab6" , "onDestroyCall")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("Lab6" , "onSaveInstanceStateCall")
        outState.apply{
            putString("userData" , binding.textView2.text.toString())
            putString("emailData" , binding.textView4.text.toString())
            putString("phoneData" , binding.textView5.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d("Lab6" , "onRestoreInstanceStateCall")
        savedInstanceState.run{
            binding.textView2.text = getString("userData")
            binding.textView4.text = getString("emailData")
            binding.textView5.text = getString("phoneData")
        }
        super.onRestoreInstanceState(savedInstanceState)
    }
}




