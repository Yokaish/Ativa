package br.com.ativa.model

import com.google.gson.annotations.SerializedName


data class Funcionarios(
    @SerializedName("id")val id: String,
    @SerializedName("nome")val nome: String,
    @SerializedName("cargo")val cargo: String,
    @SerializedName("area")val area: String,
    @SerializedName("data_inicio")val dataInicio: String
)
