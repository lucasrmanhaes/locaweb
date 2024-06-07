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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import br.com.locaweb.R
import br.com.locaweb.components.CaixaDeInput
import br.com.locaweb.components.CustomButton
import br.com.locaweb.ui.theme.Subtitle
import br.com.locaweb.ui.theme.VermelhoLocaWeb

@Composable
fun LoginScreen(loginScreenViewModel: LoginScreenViewModel) {

    val Roboto = FontFamily(
        Font(R.font.roboto_regular, FontWeight.Normal),
        Font(R.font.roboto_bold, FontWeight.Bold)
    )
    val email by loginScreenViewModel.email.observeAsState(initial = "")
    val senha by loginScreenViewModel.senha.observeAsState(initial = "")


    Box(
        modifier = Modifier.padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",

                modifier = Modifier
                    .width(300.dp)
                    .height(90.dp)
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = "O melhor lugar para os seus e-mails, \n" +
                        "notas, calendário e muito mais.",
                modifier = Modifier
                    .fillMaxWidth(),
                fontSize = 16.sp,
                fontFamily = Roboto,
                color = Subtitle,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(72.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth(),
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
                        color = VermelhoLocaWeb,
                        fontSize = 24.sp,
                        fontFamily = Roboto
                    )
                    Text(
                        text = "Acesse sua conta ou cadastre-se",
                        fontFamily = Roboto,
                    )
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

                    CustomButton(
                        text = "ENTRAR",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp)
                            .height(40.dp),
                        onClick = { /*TODO*/ })

                    CustomButton(
                        text = "Cadastre-se",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp)
                            .height(40.dp),
                        onClick = { /*TODO*/ })
            }
}
        }}}