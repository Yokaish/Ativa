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
fun BottomNavigationBar(navController: NavController, username: String) {
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
            val isSelected = currentRoute?.substringBefore("/") == item.route

            NavigationBarItem(
                icon = {
                    androidx.compose.material3.Icon(
                        painter = painterResource(id = item.icon),
                        modifier = Modifier.size(24.dp),
                        contentDescription = item.label,
                        tint = if (isSelected) Color(0xFFE01257) else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        fontFamily = PoppinsRegular,
                        color = if (isSelected) Color(0xFFE01257) else Color.Gray
                    )
                },
                selected = isSelected,
                onClick = {
                    // Passar o username para a rota correspondente
                    val destination = when (item.route) {
                        "home" -> "home/$username"  // Passa o username para a home
                        "equipe" -> "equipe/$username"  // Passa o username para equipe
                        "settings" -> "settings/$username"  // Passa o username para settings
                        else -> item.route
                    }

                    if (item.route != currentRoute) {
                        navController.navigate(destination) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = Color(0xFFE01257),
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = Color(0xFFE01257),
                    unselectedTextColor = Color.Gray
                )
            )
        }
    }
}







data class BottomNavItem(val route: String, @DrawableRes val icon: Int, val label: String)
