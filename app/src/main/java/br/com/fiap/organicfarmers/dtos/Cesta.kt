package br.com.fiap.organicfarmers.dtos

import com.google.gson.annotations.SerializedName


data class Cesta (

  @SerializedName("id"       ) var id       : Int?                = null,
  @SerializedName("nome"     ) var nome     : String?             = null,
  @SerializedName("preco"    ) var preco    : Double?             = null,
  @SerializedName("produtos" ) var produtos : ArrayList<Produto> = arrayListOf()

)