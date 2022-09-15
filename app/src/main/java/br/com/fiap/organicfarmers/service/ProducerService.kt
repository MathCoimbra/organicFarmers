package br.com.fiap.organicfarmers.service

import br.com.fiap.organicfarmers.dtos.Produtor
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProducerService {

    @GET("/Produtor")
    fun getProdutor(@Query("id") id: String): Call<Produtor>
}