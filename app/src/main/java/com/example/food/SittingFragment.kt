package com.example.food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.basicsharedprefsample.model.MySharedPref
import com.example.food.databinding.FragmentSittingBinding

class SittingFragment : Fragment(R.layout.fragment_sitting) {

    private var _binding: FragmentSittingBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSittingBinding.bind(view)
         val pref = MySharedPref(requireContext())

        _binding!!.save.setOnClickListener {
            if(_binding!!.Rlarge.isChecked){
                 pref.saveSize(40f)
            }
            if(_binding!!.Rmid.isChecked){
                pref.saveSize(30f)

            }
            if(_binding!!.Rsmall.isChecked){
                pref.saveSize(25f)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}