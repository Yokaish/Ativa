package br.com.ativa.screens.DashboardScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.ativa.R
import br.com.ativa.ui.components.FeedIconCard
import br.com.ativa.ui.components.FeedbackCard
import br.com.ativa.ui.components.Header
import br.com.ativa.ui.components.MainButton
import br.com.ativa.ui.components.PieChart
import br.com.ativa.ui.components.Title
import br.com.ativa.ui.theme.PoppinsRegular
import br.com.ativa.ui.theme.PoppinsSemibold

@Composable
fun DashboardScreen(navController: NavController, username: String) {
    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .background(Color.White)
        .padding(vertical = 30.dp, horizontal = 30.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Header(navController = navController, image = R.drawable.account, route = "settings/$username")
            Title(title = "Bem vindo, ${username.replaceFirstChar { it.uppercaseChar() }}" ,subtitle = "Veja seu resumo de desempenho")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PieChart(
                        data = mapOf(
                            Pair("Stuff", 200),
                            Pair("Inital", 100),
                        ),
                        centerText = "Bom",
                        stuffColor = Color(0xFFBEC7D7)

                    )
                    Text(text = "NOTA", fontFamily = PoppinsRegular, color = Color(0xFF45525F))
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
                        centerText = "Médio",
                        stuffColor = Color(0xFFFC588F)
                    )

                    Text(text = "FEEDBACK", fontFamily = PoppinsRegular, color = Color(0xFF45525F))
                }
            }

            FeedbackCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                label = "Feedbacks recentes",
                title = "${username.replaceFirstChar { it.uppercaseChar() }} é massa!",
                text = "Trabalho com o ${username.replaceFirstChar { it.uppercaseChar() }} a 9 meses e ele é um dos colegas de trabalho mais dedicados e legais de se ter por perto. Pode contar com ele pra tudo. Ele sempre dará um jeito de te ajudar! "
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FeedIconCard(cardText = "Feedback")
                FeedIconCard(cardText = "Nota")
                FeedIconCard(cardText = "Time")
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                contentAlignment = Alignment.Center
            ) {
                MainButton(text = "Veja mais feedbacks", font = PoppinsRegular, heightBtn = 42, onClick = {navController.navigate("feedbacks/$username")})
            }
                
            }
        }

}

@Preview
@Composable
fun DashboardScreenPrev() {
    DashboardScreen(navController = rememberNavController(), username = "Kauã")
}