package br.com.ativa.model
import com.google.gson.annotations.SerializedName

data class Feedbacks(

    @SerializedName("id") val id: String,
    @SerializedName("autor") val autor: String,
    @SerializedName("texto") val texto: String,
    @SerializedName("data_feedback") val dataFeedback: String,
    @SerializedName("funcionario_id") val funcionarioId: String
)

