package br.com.ativa.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://hgsfbaiaftwcgwhytxkx.supabase.co/rest/v1/" // URL do Supabase
    private const val API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imhnc2ZiYWlhZnR3Y2d3aHl0eGt4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDIzMDc1OTksImV4cCI6MjA1Nzg4MzU5OX0.fy8uc_Rs-0xSseKOI6JMBGI21q2bAus4PfgbkV9SWNo" // chave pública

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain: Interceptor.Chain ->
            val request = chain.request().newBuilder()
                .addHeader("apikey", API_KEY)
                .addHeader("Authorization", "Bearer $API_KEY")
                .build()
            chain.proceed(request)
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val funcionarioApi: FuncionarioApi = retrofit.create(FuncionarioApi::class.java)
    val feedbackApi: FeedbacksApi = retrofit.create(FeedbacksApi::class.java)
}