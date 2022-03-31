package com.example.singlemovie.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.singlemovie.R
import com.example.singlemovie.data.vo.MovieDetails


class MyAdapter(private val userList: ArrayList<MovieDetails>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {

        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_single_movie, parent, false)
        return MyViewHolder(v, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {

        return userList.size
    }

    class MyViewHolder(private val view: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(view) {

        fun bind(it: MovieDetails) {

            val  movieTitle = view.findViewById<TextView>(R.id.movieTitle)

            movieTitle.text = it.originalTitle
            Glide.with(view.context).load(it.posterPath).into(itemView as ImageView)

        }

        init {

            itemView.setOnClickListener{
                listener.onItemClick(bindingAdapterPosition)
            }
        }
    }
}






