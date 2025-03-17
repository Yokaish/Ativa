package br.com.ativa.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ativa.ui.theme.PoppinsRegular
import br.com.ativa.ui.theme.PoppinsSemibold

@Composable
fun FeedbackCard(modifier: Modifier, label: String? = null, title: String, text: String) {
    Column(
        modifier = modifier.fillMaxWidth() // Certifique-se de que o Column ocupe toda a largura
    ) {
        label?.let {
            Text(
                text = label,
                fontSize = 14.sp,
                fontFamily = PoppinsRegular,
                color = Color(0xFF45525F),
                modifier = Modifier.padding(bottom = 10.dp)
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth(), // O Card deve ter 100% de largura
            shape = RoundedCornerShape(size = 16.dp),
            colors = androidx.compose.material3.CardDefaults.cardColors(
                containerColor = Color(0xFFF5F6FA) // Cor de fundo do Card
            )
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontFamily = PoppinsSemibold,
                    color = Color(0xFF45525F)
                )
                Text(
                    text = text,
                    fontSize = 14.sp,
                    fontFamily = PoppinsRegular,
                    color = Color(0xFF000000)
                )
            }
        }
    }
}

@Preview
@Composable
fun FeedbackCardPreview() {
    FeedbackCard(
        modifier = Modifier.fillMaxWidth(),
        label = "Feedbacks recentes",
        title = "Abel é massa!",
        text = "Trabalho com o Abel a 9 meses e ele é um dos\n" +
                "colegas de trabalho mais dedicados e legais de\n" +
                "se ter por perto. Pode contar com ele pra tudo.\n" +
                "Ele sempre dará um jeito de te ajudar!"
    )
}

