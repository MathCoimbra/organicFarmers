package br.com.fiap.organicfarmers.dtos

import com.google.gson.annotations.SerializedName


data class Produtor (

  @SerializedName("nome"         ) var nome         : String?             = null,
  @SerializedName("email"        ) var email        : String?             = null,
  @SerializedName("telefone"     ) var telefone     : String?             = null,
  @SerializedName("dtNascimento" ) var dtNascimento : String?             = null,
  @SerializedName("endereco"     ) var endereco     : Endereco?           = Endereco(),
  @SerializedName("produtos"     ) var produtos     : ArrayList<Produto> = arrayListOf(),
  @SerializedName("cestas"       ) var cestas       : ArrayList<Cesta>   = arrayListOf()

)