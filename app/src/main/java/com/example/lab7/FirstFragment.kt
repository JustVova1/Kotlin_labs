package com.example.lab7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lab7.databinding.ActivityMainBinding
import com.example.lab7.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var result:String ?=""
        childFragmentManager.setFragmentResultListener("main_data" , this){_,bandle->
            result = bandle.getString("text")
            binding.textFirstFragment.text = result
        }
        binding.button2.setOnClickListener {
            result?.let{
                findNavController().navigate(FirstFragmentDirections.toSecondFragment(it))
            }
        }

    }


}