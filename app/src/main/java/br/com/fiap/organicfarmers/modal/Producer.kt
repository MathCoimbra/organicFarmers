package br.com.fiap.organicfarmers.modal

data class Producer(
    val name: String?,
    val street: String?,
    val city: String?,
    val phone: String?,
    val baskets: ArrayList<Basket>,
    val products: ArrayList<Product>
    )
