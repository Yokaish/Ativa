package br.com.ativa.viewmodel

import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ativa.api.RetrofitClient
import br.com.ativa.model.Funcionarios
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FuncionarioViewModel : ViewModel() {
    private val _funcionarios = mutableStateOf<List<Funcionarios>>(emptyList())
    val funcionarios: State<List<Funcionarios>> = _funcionarios

    init {
        buscarFuncionarios()
    }

    private fun buscarFuncionarios() {
        RetrofitClient.funcionarioApi.getFuncionarios().enqueue(object : Callback<List<Funcionarios>> {
            override fun onResponse(call: Call<List<Funcionarios>>, response: Response<List<Funcionarios>>) {
                if (response.isSuccessful) {
                    _funcionarios.value = response.body() ?: emptyList()
                }
            }

            override fun onFailure(call: Call<List<Funcionarios>>, t: Throwable) {
                println("Erro ao buscar funcionários: ${t.message}")
            }
        })
    }
}