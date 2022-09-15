package br.com.fiap.organicfarmers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.fiap.organicfarmers.databinding.ActivityCartBinding
import br.com.fiap.organicfarmers.databinding.ActivityMainBinding

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
    }

    fun onClickCartBtn(view: View) {
        val intent = Intent(this, ProducerActivity::class.java)
        startActivity(intent)
    }
}