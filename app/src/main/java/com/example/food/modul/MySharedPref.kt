package com.example.basicsharedprefsample.model

import android.content.Context


class MySharedPref(context: Context) {

    companion object {

        private const val Size =30f
        private const val Key = "info"




    }
    private val sharedPref = context.getSharedPreferences(Key, Context.MODE_PRIVATE)

    fun saveSize(size:Float){
       sharedPref.edit()
           .putFloat(Size.toString(),size)
           .apply()

    }

    fun getSize(): Float? {
          return sharedPref.getFloat(Size.toString(),30f)
    }


}
