package br.com.ativa.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.ativa.R
import br.com.ativa.ui.components.EmployeeCard
import br.com.ativa.ui.components.FeedbackCard
import br.com.ativa.ui.components.Header
import br.com.ativa.ui.components.MainButton
import br.com.ativa.ui.components.Title
import br.com.ativa.ui.theme.PoppinsRegular

@Composable
fun TeamScreen(
    navController: NavController,
    username: String
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .background(Color.White)
        .padding(vertical = 30.dp, horizontal = 30.dp)
    ) {
       Column(
       ) {

           Header(navController = navController, image = R.drawable.account, route = "settings/$username")
           Title(title = "Veja sua equipe")

           Column(
               modifier = Modifier.padding(vertical = 32.dp),
               verticalArrangement = Arrangement.spacedBy(16.dp)
           ) {

               EmployeeCard(
                   image = R.drawable.picture_1,
                   role = "Mobile Developer",
                   name = "${username.replaceFirstChar { it.uppercaseChar() }}",
                   employData = "Funcionário desde 2025"
               )

               EmployeeCard(
                   image = R.drawable.picture_2,
                   role = "UI/UX Designer",
                   name = "Geovana Mendes",
                   employData = "Funcionário desde 2022"
               )

               EmployeeCard(
                   image = R.drawable.picture_3,
                   role = "Developer",
                   name = "Sabrina Alves",
                   employData = "Funcionário desde 2024"
               )

               EmployeeCard(
                   image = R.drawable.picture_4,
                   role = "Developer",
                   name = "Fernando Oliveira",
                   employData = "Funcionário desde 2024"
               )

               EmployeeCard(
                   image = R.drawable.picture_5,
                   role = "Developer",
                   name = "Samuel Silva",
                   employData = "Funcionário desde 2025"
               )
           }

           FeedbackCard(modifier = Modifier, title = "Próxima reunião", text = "Segunda Feira 19/05/2025 - 07:00AM\nHost: Daniel Oliveira")
           Row(modifier = Modifier.padding(top = 32.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
               MainButton(onClick = { /*TODO*/ }, font = PoppinsRegular, heightBtn = 40, text = "Ver outras reuniões")
           }
       }
    }
}

@Preview
@Composable
fun TeamScreenPreview() {
    TeamScreen(
        navController = rememberNavController(), username = "Kauã",
    )
}