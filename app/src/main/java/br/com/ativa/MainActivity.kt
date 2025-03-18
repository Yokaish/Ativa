package br.com.ativa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.ativa.screens.DashboardScreen.DashboardScreen
import br.com.ativa.screens.FeedbacksScreen.FeedbacksScreen
import br.com.ativa.screens.LoginScreen.LoginScreen
import br.com.ativa.screens.LoginScreen.LoginScreenViewModel
import br.com.ativa.screens.SettingsScreen.SettingsScreen
import br.com.ativa.screens.TeamScreen
import br.com.ativa.ui.components.BottomNavigationBar
import br.com.ativa.ui.theme.AtivaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AtivaTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,

                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // Estado para armazenar o username
    var username by remember { mutableStateOf("Visitante") }

    val currentBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentDestination = currentBackStackEntry?.destination

    val showBottomBar = currentDestination?.route !in listOf("login")

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigationBar(navController, username)  // Passa o username para a BottomNavigationBar
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            NavHost(navController, startDestination = "login") {
                composable("login") {
                    LoginScreen(LoginScreenViewModel(), navController, onLoginSuccess = { user ->
                        // Atualiza o username após login
                        username = user
                    })
                }

                composable("home/{username}") { backStackEntry ->
                    val username = backStackEntry.arguments?.getString("username") ?: "Visitante"
                    DashboardScreen(navController, username)
                }
                composable("equipe/{username}") { backStackEntry ->
                    val username = backStackEntry.arguments?.getString("username") ?: "Visitante"
                    TeamScreen(navController, username)
                }
                composable("settings/{username}") { backStackEntry ->
                    val username = backStackEntry.arguments?.getString("username") ?: "Visitante"
                    SettingsScreen(navController, username)
                }
                composable("feedbacks/{username}") { backStackEntry ->
                    val username = backStackEntry.arguments?.getString("username") ?: "Visitante"
                    FeedbacksScreen(navController, username)
                }
            }
        }
    }
}




