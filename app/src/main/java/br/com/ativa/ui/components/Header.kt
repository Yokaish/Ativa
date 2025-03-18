package br.com.ativa.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.ativa.R

@Composable
fun Header(navController: NavController, @DrawableRes image: Int? = null, route: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ativa_logo_no_text),
                contentDescription = "Ícone de Conta",
                modifier = Modifier
                    .size(90.dp)
                    .padding(0.dp)
            )

            // Renderiza o ícone apenas se `image` não for nulo
            image?.let {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = "Ícone de Conta",
                    tint = Color(0xFFE01257),
                    modifier = Modifier.size(28.dp).clickable {
                        navController.navigate(route) {
                            launchSingleTop = true // Evita empilhar múltiplas telas de settings
                        }
                    }
                )
            }
        }
    }
}

