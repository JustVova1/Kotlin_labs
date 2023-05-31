package com.example.lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.lab5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener{
            myOnClickMethod(it)
            selectAllCheckBox(it)
        }
        binding.editTextName.setOnClickListener{
            fun onClick(p0:View){
                binding.textView.text = getString(R.string.editTextName)
            }
        }
        binding.editTextName.addTextChangedListener{
            binding.textView.text = getString(R.string.editTextChanging)
        }

    }
    private fun myOnClickMethod(v:View){
        Toast.makeText(this,"Selected all",Toast.LENGTH_SHORT).show()
    }
    private fun selectAllCheckBox(v:View){
        val isCheck1 = binding.checkBox
        isCheck1.isChecked = true
        val isCheck2 = binding.checkBox2
        isCheck2.isChecked = true
    }
}