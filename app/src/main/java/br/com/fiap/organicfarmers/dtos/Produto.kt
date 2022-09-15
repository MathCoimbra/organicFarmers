package br.com.fiap.organicfarmers.dtos

import com.google.gson.annotations.SerializedName


data class Produto (

  @SerializedName("nome"              ) var nome              : String?                      = null,
  @SerializedName("preco"             ) var preco             : Double?                      = null,
  @SerializedName("categoria"         ) var categoria         : String?                      = null,
  @SerializedName("estoqueDisponivel" ) var estoqueDisponivel : ArrayList<EstoqueDisponivel> = arrayListOf(),
  @SerializedName("url"               ) var url               : String?                      = null

)