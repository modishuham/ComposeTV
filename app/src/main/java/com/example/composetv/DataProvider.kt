package com.example.composetv

import android.content.Context
import com.example.composetv.model.Item
import com.example.composetv.model.Movie
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object DataProvider {

    private fun getMovies(context: Context): ArrayList<Movie> {
        val data =
            context.resources.openRawResource(R.raw.movies).bufferedReader().use { it.readText() }
        val gson = GsonBuilder().create()
        return gson.fromJson(data, object : TypeToken<ArrayList<Movie>>() {}.type)
    }

    fun getHomeData(context: Context): ArrayList<Item> {
        val item1 = Item("Top Movies", getMovies(context))
        val item2 = Item("Movies for Yor", getMovies(context))
        val item3 = Item("Best Movies", getMovies(context))
        val item4 = Item("Action Movies", getMovies(context))
        return arrayListOf(item1, item2, item3, item4)
    }

}