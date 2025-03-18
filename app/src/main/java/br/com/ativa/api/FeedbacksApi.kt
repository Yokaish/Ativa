package br.com.ativa.api

import br.com.ativa.model.Feedbacks
import retrofit2.Call
import retrofit2.http.GET

interface FeedbacksApi {
    @GET("rest/v1/feedbacks")
    fun getFeedbacks():Call<List<Feedbacks>>
}