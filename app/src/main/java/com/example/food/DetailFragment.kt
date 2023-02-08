package com.example.food

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import coil.load
import com.example.basicsharedprefsample.model.MySharedPref

import com.example.food.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailBinding.bind(view)
        val pref = MySharedPref(requireContext())
        var r=pref.getpsition()
        var ff=FoodFragment()
        var NameImg=ff.namesList
        var name=NameImg[r].name
       binding.apply {
            imageView3.load((NameImg[r].imageUrl))
            textView3.setText(name)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}