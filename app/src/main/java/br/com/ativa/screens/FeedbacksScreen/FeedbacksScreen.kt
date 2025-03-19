package br.com.ativa.screens.FeedbacksScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.ativa.R
import br.com.ativa.ui.components.Header
import br.com.ativa.ui.components.MainButton
import br.com.ativa.ui.components.PieChart
import br.com.ativa.ui.components.ReactionFeedback
import br.com.ativa.ui.components.Title
import br.com.ativa.ui.theme.PoppinsRegular

@Composable
fun FeedbacksScreen(navController: NavController, username: String) {
    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .background(Color.White)
        .padding(vertical = 30.dp, horizontal = 30.dp))
    {
        Column() {
            Header(navController = navController, image = R.drawable.account, route = "settings/$username")
            Title(title = "Seus feedbacks")
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PieChart(
                        data = mapOf(
                            Pair("Stuff", 70),
                            Pair("Inital", 100),
                        ),
                        centerText = "Fevereiro",
                        stuffColor = Color(0xFF0098FF)
                    )

                    Text(text = "Alto", fontFamily = PoppinsRegular, color = Color(0xFF45525F))
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PieChart(
                        data = mapOf(
                            Pair("Stuff", 70),
                            Pair("Inital", 100),
                        ),
                        centerText = "Março",
                        stuffColor = Color(0xFF09F9BF)
                    )

                    Text(text = "Médio", fontFamily = PoppinsRegular, color = Color(0xFF45525F))
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "O que os seus colegas\nestão falando sobre você?", color = Color(0xFF45525F))
                Icon(
                    painter = painterResource(id = R.drawable.verified),
                    contentDescription = "Ícone de Verificado",
                    modifier = Modifier.size(24.dp),
                    tint = Color(0xFFE01257)
                )
            }

            Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                ReactionFeedback(
                    text = "Eu gosto muito de trabalhar com ${username.replaceFirstChar { it.uppercaseChar() }}, é uma pessoa fácil de...",
                    reactDescription = "very_happy"
                )
                ReactionFeedback(
                    text = "${username.replaceFirstChar { it.uppercaseChar() }} é um pouco distante.",
                    reactDescription = "neutral"
                )
                ReactionFeedback(
                    text = "${username.replaceFirstChar { it.uppercaseChar() }} é muito gente boa. Ele está sempre disponível quando pre...",
                    reactDescription = "happy"
                )
            }

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                MainButton(onClick = { /*TODO*/ }, font = PoppinsRegular, heightBtn = 40, text = "Veja suas notas")
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                PieChart(
                    data = mapOf(
                        Pair("Stuff", 70),
                        Pair("Inital", 100),
                    ),
                    centerText = "52/87",
                    stuffColor = Color(0xFFFC588F)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .clip(RoundedCornerShape(8.dp)) //
                                .background(Color(0xFFFC588F)),
                        )
                        Text(text = "Sociabilidade", color = Color(0xFF45525F), fontSize = 14.sp)
                    }

                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .clip(RoundedCornerShape(8.dp)) //
                                .background(Color(0xFFF5F6FA)),
                        )
                        Text(text = "Engajamento", color = Color(0xFF45525F), fontSize = 14.sp)
                    }

                }
            }

            Text(text = "*Tenha em mente que os gráficos não sou um reflexo exato do trabalho que você está fazendo. As informações são registradas para ajudar o seu desempenho na empresa.", fontSize = 10.sp, color = Color(0xFF45525F))

        }
    }
}

@Preview
@Composable
fun FeedbacksScreenPreview() {
    FeedbacksScreen(navController = rememberNavController(), username = "Kauã")
}