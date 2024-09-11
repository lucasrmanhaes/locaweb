    package br.com.locaweb
    import android.app.Application
    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Surface
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.livedata.observeAsState
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.platform.LocalContext
    import androidx.lifecycle.viewmodel.compose.viewModel
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import br.com.locaweb.screens.CaixaDeEmailsScreen
    import br.com.locaweb.screens.CaixaDeEntradaScreen
    import br.com.locaweb.screens.EmailAbertoScreen
    import br.com.locaweb.screens.LoginScreen
    import br.com.locaweb.screens.LoginScreenViewModel
    import br.com.locaweb.screens.TelaConfiguracoesScreen
    import br.com.locaweb.screens.TelaConfiguracoesViewModel
    import br.com.locaweb.screens.TelaInicialScreen
    import br.com.locaweb.screens.TelaScreen
    import br.com.locaweb.ui.theme.LocawebTheme

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()

            // Recuperar o tema do SharedPreferences ao iniciar a aplicação
            val sharedPreferences = getSharedPreferences("AppPreferences", MODE_PRIVATE)
            val savedTheme = sharedPreferences.getString("USER_THEME", "light")

            // Definir estado reativo para o tema
            var isDarkTheme by mutableStateOf(savedTheme == "dark")

            setContent {
                val telaConfiguracoesViewModel: TelaConfiguracoesViewModel = viewModel()

                LocawebTheme(darkTheme = isDarkTheme) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
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
                            composable(route = "TelaConfiguracoes") {
                                TelaConfiguracoesScreen(
                                    telaConfiguracoesViewModel,
                                    navController
                                )
                            }
                        }
                    }
                }
            }
        }
    }
