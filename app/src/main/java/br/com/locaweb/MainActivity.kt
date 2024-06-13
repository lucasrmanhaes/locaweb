package br.com.locaweb


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.locaweb.screens.CaixaDeEmailsScreen
import br.com.locaweb.screens.CaixaDeEntradaScreen
import br.com.locaweb.screens.EmailAbertoScreen
import br.com.locaweb.screens.LoginScreen
import br.com.locaweb.screens.LoginScreenViewModel
import br.com.locaweb.screens.TelaInicialScreen
import br.com.locaweb.screens.TelaScreen
import br.com.locaweb.ui.theme.LocawebTheme
import br.com.locaweb.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LocawebTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = White
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "login") {
                        composable(route = "login") {
                            LoginScreen(
                                LoginScreenViewModel(),
                                navController
                            )
                        }
                        composable(route = "TelaInicial") { TelaInicialScreen(navController) }
                        composable(route = "Tela") { TelaScreen(navController) }
                        composable(route = "TelaContasDeEmail") { CaixaDeEmailsScreen(navController) }
                        composable(route = "TelaListaEmails/{emailType}") { backStackEntry ->
                            val emailType = backStackEntry.arguments?.getString("emailType")?.toIntOrNull() ?: 1
                            CaixaDeEntradaScreen(navController, emailType)
                        }
                        composable(route = "EmailAgendamentoAberto") {
                            EmailAbertoScreen(
                                navController
                            )
                        }

                    }
                    //LoginScreen(LoginScreenViewModel())
                    //TelaInicialScreen()
                    //CaixaDeEntradaScreen()
                    //CaixaDeEmailsScreen()
                    //EmailAbertoScreen()
                }
            }
        }

    }}