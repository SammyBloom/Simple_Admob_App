package com.example.moviedisplay.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedisplay.R
import com.example.moviedisplay.model.MovieItem
import com.google.android.material.textfield.TextInputEditText
import com.squareup.picasso.Picasso

class MovieAdapter(var context: Context, var mMovies: ArrayList<MovieItem>) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bindItems(list: MovieItem){
            var name = itemView.findViewById<TextView>(R.id.movie_name)
            var description = itemView.findViewById<TextView>(R.id.movie_description)

            name.text = list.name
            description.text = list.description
//            Picasso.get().load(list.avatar)
//                .fit()
//                .centerCrop()
//                .into(img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        return holder.bindItems(mMovies[position])
    }

    override fun getItemCount(): Int {
        return mMovies.size
    }
}