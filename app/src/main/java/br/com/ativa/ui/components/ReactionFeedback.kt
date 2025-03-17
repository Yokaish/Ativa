package br.com.ativa.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ativa.R

@Composable
fun ReactionFeedback(
    text: String,
    reactDescription: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(8.dp)) // Aplica o shape primeiro
                .background(
                    when (reactDescription) {
                        "very_sad" -> Color(0xFFEA334D)
                        "sad" -> Color(0xFFFF7E1E)
                        "neutral" -> Color(0xFFFFCF2C)
                        "happy" -> Color(0xFFADDB1A)
                        "very_happy" -> Color(0xFF4ECE59)
                        else -> Color.Gray // Cor padrão caso não seja "good"
                    }
                ), // Agora o background respeita o shape
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                painter = painterResource(
                    when (reactDescription) {
                        "very_sad" -> R.drawable.very_sad
                        "sad" -> R.drawable.sad
                        "neutral" -> R.drawable.neutral
                        "happy" -> R.drawable.happy
                        "very_happy" -> R.drawable.very_happy
                        else -> R.drawable.verified // Ícone padrão
                    }
                ),
                contentDescription = "Ícone de Reação",
                modifier = Modifier.size(28.dp),
                tint = Color(0xFFFFFFFF)
            )

        }
        Text(text = text, fontSize = 12.sp, color = Color(0xFF45525F), modifier = Modifier.fillMaxWidth())

    }
}

@Preview
@Composable
fun ReactionFeedbackPreview() {
    ReactionFeedback(text = "Eu gosto muito de trabalhar com o Abel, ele é uma pessoa fácil de lidar e de se ter..." , reactDescription = "very_happy")
}