package br.com.ativa.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
fun ProfileFeedbackCard() {
    var feedbackText by remember { mutableStateOf("Escolha uma opção acima") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Container dos ícones
        Row(
            modifier = Modifier.padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            FeedbackIcon(R.drawable.verified, "Opção 1") { feedbackText = "Você escolheu a opção 1" }
            Spacer(modifier = Modifier.width(12.dp))
            FeedbackIcon(R.drawable.verified, "Opção 2") { feedbackText = "Você escolheu a opção 2" }
            Spacer(modifier = Modifier.width(12.dp))
            FeedbackIcon(R.drawable.verified, "Opção 3") { feedbackText = "Você escolheu a opção 3" }
        }

        // Card
        Card(
            modifier = Modifier.fillMaxWidth(0.9f),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F6FA))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = feedbackText,
                    fontSize = 16.sp,
                    fontFamily = PoppinsRegular
                )
            }
        }
    }
}

@Composable
fun FeedbackIcon(iconRes: Int, contentDescription: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(Color.LightGray, shape = CircleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = contentDescription,
            modifier = Modifier.size(30.dp)
        )
    }
}

@Preview
@Composable
fun ProfileFeedbackCardPreview() {
    ProfileFeedbackCard()
}
