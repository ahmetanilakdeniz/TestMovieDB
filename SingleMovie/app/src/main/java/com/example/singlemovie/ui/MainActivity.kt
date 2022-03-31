package com.example.singlemovie.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.singlemovie.R
import com.example.singlemovie.ui.single_movie_details.SingleMovie


class MainActivity : AppCompatActivity() {

     private  var btn : Button? = null

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         btn?.setOnClickListener {
             val intent = Intent(this, SingleMovie::class.java)
             intent.putExtra("id",278)
             this.startActivity(intent)
         }
     }
}





