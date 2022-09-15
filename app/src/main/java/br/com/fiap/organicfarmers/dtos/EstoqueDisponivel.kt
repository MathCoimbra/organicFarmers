package br.com.fiap.organicfarmers.dtos

import com.google.gson.annotations.SerializedName


data class EstoqueDisponivel (

  @SerializedName("qtdDisponivel" ) var qtdDisponivel : Int?    = null,
  @SerializedName("dtProducao"    ) var dtProducao    : String? = null,
  @SerializedName("dtVencimento"  ) var dtVencimento  : String? = null

)