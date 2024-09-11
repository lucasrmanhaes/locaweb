    package br.com.locaweb.screens

    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.width
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.Lock
    import androidx.compose.material3.Card
    import androidx.compose.material3.CardDefaults
    import androidx.compose.material3.Icon
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.livedata.observeAsState
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.text.font.Font
    import androidx.compose.ui.text.font.FontFamily
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.text.input.KeyboardType
    import androidx.compose.ui.text.style.TextAlign
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.navigation.NavController
    import br.com.locaweb.R
    import br.com.locaweb.components.CaixaDeInput
    import br.com.locaweb.components.CustomButton

    @Composable
    fun LoginScreen(loginScreenViewModel: LoginScreenViewModel, navController: NavController) {

        val Roboto = FontFamily(
            Font(R.font.roboto_regular, FontWeight.Normal),
            Font(R.font.roboto_bold, FontWeight.Bold)
        )
        val email by loginScreenViewModel.email.observeAsState(initial = "")
        val senha by loginScreenViewModel.senha.observeAsState(initial = "")
        val loginResult by loginScreenViewModel.loginSuccess.observeAsState()
        val errorMessage by loginScreenViewModel.errorMessage.observeAsState()

        var selectedTheme by remember { mutableStateOf("light") } // Estado para o tema atual

        // Observa mudanças de tema salvas com sucesso
        val themeSaved by loginScreenViewModel.themeSaved.observeAsState()

        // Troca o tema caso ele seja salvo com sucesso
        themeSaved?.let {
            selectedTheme = it // Atualiza o tema selecionado
        }

        Box(
            modifier = Modifier.padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo",
                    modifier = Modifier
                        .width(300.dp)
                        .height(90.dp)
                        .padding(top = 16.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(22.dp))
                Text(
                    text = "LocawebMail",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    fontFamily = Roboto,
                    color = MaterialTheme.colorScheme.tertiary,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "O melhor lugar para os seus e-mails, \n" +
                            "notas, calendário e muito mais.",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    fontFamily = Roboto,
                    color = MaterialTheme.colorScheme.tertiary,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(72.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(Color(0xFFF2F2F7))
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .background(Color.Transparent)
                    ) {
                        Text(
                            text = "Olá!",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary, // Usando a cor primária do tema
                            fontSize = 24.sp,
                            fontFamily = Roboto
                        )
                        Text(
                            text = "Acesse sua conta ou cadastre-se",
                            fontFamily = Roboto,
                            color = MaterialTheme.colorScheme.secondary
                        )

                        // Campo de input para o email
                        CaixaDeInput(
                            label = "Email",
                            value = email,
                            keyboardType = KeyboardType.Email,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp)
                        ) {
                            loginScreenViewModel.onEmailChanged(it)
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Campo de input para a senha
                        CaixaDeInput(
                            label = "Senha",
                            value = senha,
                            keyboardType = KeyboardType.Password,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                        ) {
                            loginScreenViewModel.onSenhaChanged(it)
                        }

                        Spacer(modifier = Modifier.height(32.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "Ícone de senha",
                                tint = Color(0xFF1E1B19)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Esqueci minha senha",
                                color = Color(0xFF1E1B19)
                            )
                        }

                        // Botão para fazer o login
                        CustomButton(
                            text = "ENTRAR",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 32.dp)
                                .height(40.dp),
                            onClick = {
                                loginScreenViewModel.login(navController.context) // Chama a função de validação de login
                            }
                        )

                        // Exibe a mensagem de erro, se houver
                        if (loginResult == false) {
                            errorMessage?.let {
                                Text(
                                    text = it,
                                    color = Color.Red,
                                    modifier = Modifier.padding(top = 16.dp)
                                )
                            }
                        }

                        // Redireciona para a tela inicial após o login bem-sucedido
                        if (loginResult == true) {
                            navController.navigate("telaInicial") {
                                popUpTo("login") { inclusive = true }  // Remove a tela de login do backstack
                            }
                        }
                    }
                }
            }
        }
    }
