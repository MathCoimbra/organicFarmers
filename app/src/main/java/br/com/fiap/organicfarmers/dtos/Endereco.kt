package br.com.fiap.organicfarmers.dtos

import com.google.gson.annotations.SerializedName


data class Endereco (

  @SerializedName("id"          ) var id          : Int?    = null,
  @SerializedName("numero"      ) var numero      : Int?    = null,
  @SerializedName("localizacao" ) var localizacao : String? = null,
  @SerializedName("bairro"      ) var bairro      : String? = null,
  @SerializedName("complemento" ) var complemento : String? = null,
  @SerializedName("cidade"      ) var cidade      : String? = null,
  @SerializedName("uf"          ) var uf          : String? = null,
  @SerializedName("cep"         ) var cep         : String? = null

)