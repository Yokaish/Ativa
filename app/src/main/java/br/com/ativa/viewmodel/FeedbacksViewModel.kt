package br.com.ativa.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import br.com.ativa.api.RetrofitClient
import br.com.ativa.model.Feedbacks
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedbacksViewModel : ViewModel() {
    private val _feedbacks = mutableStateOf<List<Feedbacks>>(emptyList())
    val feedbacks: State<List<Feedbacks>> = _feedbacks

    init {
        buscarFeedbacks()
    }

    private fun buscarFeedbacks() {
        RetrofitClient.feedbackApi.getFeedbacks().enqueue(object : Callback<List<Feedbacks>> {
            override fun onResponse(call: Call<List<Feedbacks>>, response: Response<List<Feedbacks>>) {
                if (response.isSuccessful) {
                    _feedbacks.value = response.body() ?: emptyList()
                }
            }

            override fun onFailure(call: Call<List<Feedbacks>>, t: Throwable) {
                println("Erro ao buscar feedbacks: ${t.message}")
            }
        })
    }
}