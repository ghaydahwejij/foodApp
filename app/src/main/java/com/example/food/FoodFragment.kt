package com.example.food

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.basicsharedprefsample.model.MySharedPref
import com.example.food.databinding.FragmentFoodBinding

class FoodFragment : Fragment(R.layout.fragment_food) {


    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!

    val namesList = mutableListOf(
        Food("Watermelon", R.drawable.images__1_),
        Food("Banan", R.drawable.images),
        Food("Burger", R.drawable.burger2),
        Food("Spaghetti ", R.drawable.images__4_),
        Food("Pizza ", R.drawable.images__3_),


        )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = MySharedPref(requireContext())
        _binding = FragmentFoodBinding.bind(view)




        val adapter = FoodAdapter()
         binding.rc.adapter=adapter
        adapter.submitList(namesList)


        adapter.s= pref.getSize()!!
        Log.d("taggg",adapter.s.toString())

        binding.rc.adapter=adapter
        adapter.submitList(namesList)

        adapter.setOnItemClickListener(object : FoodAdapter.onItemClickListener {

            override fun onItemClick(Position: Int) {
                super.onItemClick(Position)
//             Toast.makeText(this@FoodFragment,"ggg",Toast.LENGTH_LONG).show()
                pref.savePostion(Position)
                val action=FoodFragmentDirections.actionFoodFragmentToDetailFragment()
                view.findNavController().navigate(action)
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}