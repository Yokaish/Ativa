package br.com.ativa.ui.components

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import br.com.ativa.R
import br.com.ativa.ui.theme.PoppinsRegular

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("home", R.drawable.home, "Home"),
        BottomNavItem("equipe", R.drawable.team, "Equipe"),
        BottomNavItem("settings", R.drawable.settings, "Configurações")
    )

    NavigationBar(
        containerColor = Color.White // Define a barra como branca
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        items.forEach { item ->
            val isSelected = currentRoute == item.route

            NavigationBarItem(
                icon = {
                    androidx.compose.material3.Icon(
                        painter = painterResource(id = item.icon),
                        modifier = Modifier.size(24.dp),
                        contentDescription = item.label,
                        tint = if (isSelected) Color(0xFFE01257) else Color.Gray)
                },
                label = {
                    Text(
                        text = item.label,
                        fontFamily = PoppinsRegular,
                        color = if (isSelected) Color(0xFFE01257) else Color.Gray // Texto rosa quando selecionado, cinza quando não
                    )
                },
                selected = isSelected,
                onClick = {
                    // Evitar múltiplas instâncias da mesma tela
                    if (item.route != currentRoute) {
                        navController.navigate(item.route) {
                            // Mantém a pilha intacta, sem reentrar em "home" se já estiver lá
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent, // Remove o fundo azul ao selecionar
                    selectedIconColor = Color(0xFFE01257), // Cor do ícone quando selecionado
                    unselectedIconColor = Color.Gray, // Cor do ícone quando não selecionado
                    selectedTextColor = Color(0xFFE01257), // Cor do texto quando selecionado
                    unselectedTextColor = Color.Gray // Cor do texto quando não selecionado
                )
            )
        }
    }
}




data class BottomNavItem(val route: String, @DrawableRes val icon: Int, val label: String)
