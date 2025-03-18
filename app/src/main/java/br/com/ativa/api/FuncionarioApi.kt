package br.com.ativa.api

import br.com.ativa.model.Funcionarios
import retrofit2.Call
import retrofit2.http.GET

interface FuncionarioApi {
    @GET("rest/v1/funcionarios")
    fun getFuncionarios():Call<List<Funcionarios>>
}