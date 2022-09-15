package br.com.fiap.organicfarmers.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import br.com.fiap.organicfarmers.dtos.Produtor
import br.com.fiap.organicfarmers.modal.Basket
import br.com.fiap.organicfarmers.modal.Producer
import br.com.fiap.organicfarmers.modal.Product
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


class ProdutorToProducer {

    companion object {
        fun execute(produtor: Produtor): Producer {

            val baskets = produtor.cestas.map {
                Basket(
                    name = it.nome,
                    price = produtor.produtos.size.toString()
                            + " itens por R$:" + it.preco.toString()
                )
            }


            val products = produtor.produtos.map {

                var theAmount = "0"
                if (it.estoqueDisponivel.size != 0) {
                    theAmount = it.estoqueDisponivel[0].qtdDisponivel.toString()
                }
                Product(name = it.nome,
                    price = "R$"+ it.preco.toString(),
                    urlImg = it.url,
                    theAmount = theAmount + " unidade",
                    category = it.categoria
                )
            }

            return Producer(
                name = produtor.nome,
                street = produtor.endereco?.localizacao
                        + ", " + produtor.endereco?.numero.toString()
                        + " - " + produtor.endereco?.bairro,
                city = produtor.endereco?.cidade,
                phone = produtor.telefone,
                baskets = ArrayList(baskets),
                products = ArrayList(products)

            )
        }

        private fun getBitmapFromURL(imageUrl: String?): Bitmap? {
            return try {
                val url = URL(imageUrl)
                val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
                connection.doInput = true
                connection.connect()
                val input: InputStream = connection.inputStream
                BitmapFactory.decodeStream(input)
            } catch (e: IOException) {
                e.printStackTrace()
                null
            }
        }
    }

}