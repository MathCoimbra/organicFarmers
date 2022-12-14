package br.com.fiap.organicfarmers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import br.com.fiap.organicfarmers.adapter.ProdutorToProducer
import br.com.fiap.organicfarmers.dtos.Produtor
import br.com.fiap.organicfarmers.factory.ProducerFactory
import br.com.fiap.organicfarmers.fragment.ListBasketFragment
import br.com.fiap.organicfarmers.fragment.ListProductCategoryFragment
import br.com.fiap.organicfarmers.modal.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProducerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producer)

        if (savedInstanceState == null) {

            val producerId = intent.getIntExtra("producerId", 0)

            val call = ProducerFactory().getProducerService().getProdutor(producerId.toString())

            call.enqueue(object: Callback<Produtor>{
                override fun onResponse(call: Call<Produtor>, response: Response<Produtor>) {
                    response.body()?.let {
                        Log.i("Produtor", it.toString())

                        val producer = ProdutorToProducer.execute(it)

                        Log.i("Produce", producer.toString())

                        findViewById<TextView>(R.id.produce_name).text = producer.name
                        findViewById<TextView>(R.id.produce_street).text = producer.street
                        findViewById<TextView>(R.id.produce_city).text = producer.city
                        findViewById<TextView>(R.id.produce_phone).text = producer.phone

                        supportFragmentManager
                            .beginTransaction()
                            .add(R.id.container_root_basket, ListBasketFragment.newInstance(producer.baskets), "ListBasket")
                            .add(R.id.container_root_product_fruits, ListProductCategoryFragment.newInstance(
                                producer.products.filter{ s -> s.category?.lowercase() == "frutas" } as ArrayList<Product>, "Frutas"), "ListProductCategoryFruits")
                            .add(R.id.container_root_product_greens, ListProductCategoryFragment.newInstance(
                                producer.products.filter{ s -> s.category?.lowercase() == "verduras" } as ArrayList<Product>, "Verduras"), "ListProductCategoryGreens")
                            .add(R.id.container_root_product_greenstuff, ListProductCategoryFragment.newInstance(producer.products.filter{ s -> s.category?.lowercase() == "legumes" } as ArrayList<Product>, "Legumes"), "ListProductCategoryGreenstuff")
                            .commit()
                    } ?: Toast.makeText(
                        this@ProducerActivity,
                        "Produtor n??o encontrado",
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onFailure(call: Call<Produtor>, t: Throwable) {
                    t.message.let { Log.e("produtor error", it.toString())
                        Toast.makeText(
                            this@ProducerActivity,
                            "Produtor n??o encontrado",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            })
        }
    }

    fun onClickMainBtn(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}