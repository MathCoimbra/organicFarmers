package br.com.fiap.organicfarmers.factory

import br.com.fiap.organicfarmers.service.ProducerService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ProducerFactory {

    private val baseURL: String = "https://organicf.azurewebsites.net"

    private val retroFitFactory = Retrofit
        .Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getProducerService() : ProducerService = retroFitFactory
        .create(ProducerService::class.java)
}