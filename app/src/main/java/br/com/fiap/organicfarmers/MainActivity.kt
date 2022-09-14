package br.com.fiap.organicfarmers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)

        imageView.setImageResource(R.drawable.union)

    }

     fun onClick(view: View) {
         val intent = Intent(this, ProducerActivity::class.java)
         startActivity(intent)
     }

}