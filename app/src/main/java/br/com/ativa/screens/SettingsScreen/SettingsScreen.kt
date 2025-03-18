package br.com.ativa.screens.SettingsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.ativa.ui.components.Header
import br.com.ativa.ui.components.MainButton
import br.com.ativa.ui.components.ProfileCard
import br.com.ativa.ui.components.ProfileFeedbackCard
import br.com.ativa.ui.components.SettingOption
import br.com.ativa.ui.components.Title
import br.com.ativa.ui.theme.PoppinsSemibold

@Composable
fun SettingsScreen(navController: NavController, username: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
            .padding(vertical = 30.dp, horizontal = 30.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header(navController = navController)

            // Adiciona um espaçamento entre o Header e o Title

            Title(
                title = "Configurações da conta",
                subtitle = "Suas informações pessoais serão absolutamente confidenciais para nós"
            )
            ProfileCard(modifier = Modifier.padding(vertical = 16.dp), username = username)
            MainButton(onClick = { /*TODO*/ }, font = PoppinsSemibold , heightBtn = 40, text = "Editar Perfil")
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.padding(top = 16.dp)
            ) {
                SettingOption(modifier = Modifier, text = "Modo escuro", btnType = "toggle")
                SettingOption(modifier = Modifier, text = "Linguagem", btnType = "arrow")
                SettingOption(modifier = Modifier, text = "Notificações do sistema", btnType = "toggle")
                Text(
                    text = "Sair do aplicativo",
                    modifier = Modifier.padding(top = 6.dp).clickable(onClick = {navController.navigate("login")}),
                    color = Color.Red,
                    fontSize = 14.sp,
                    fontFamily = PoppinsSemibold,

                )
            }
        }
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(navController = rememberNavController(), username = "Kauã")
}

