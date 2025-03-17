package br.com.ativa.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ativa.R
import br.com.ativa.ui.theme.PoppinsRegular

@Composable
fun FeedIconCard(cardText: String) {
    Card(
        modifier = Modifier.width(104.dp),
        colors = androidx.compose.material3.CardDefaults.cardColors(
            containerColor = Color(0xFFF5F6FA) // Cor de fundo do Card
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // Aplicando padding de forma geral
        ) {
            Icon(
                painter = painterResource(id = R.drawable.verified),
                contentDescription = "Ícone Verificado",
                modifier = Modifier.size(28.dp),
                tint = Color(0xFFE01257)
            )
            Text(
                text = cardText,
                fontFamily = PoppinsRegular,
                fontSize = 12.sp,
                color = Color(0xFFE01257),
                modifier = Modifier.align(Alignment.CenterHorizontally) // Certificando que o texto também esteja centralizado
            )
        }
    }
}



@Preview
@Composable
fun FeedIconCardPreview() {
    FeedIconCard("Feedback")
}