package br.com.locaweb.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.locaweb.R
import br.com.locaweb.ui.theme.Subtitle

@Composable
fun TelaScreen(navController: NavController){

    val Roboto = FontFamily(
        Font(R.font.roboto_regular, FontWeight.Normal),
        Font(R.font.roboto_bold, FontWeight.Bold)
    )
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

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        navController.navigate("TelaInicial")
                    }
                ) {
                    Icon(
                        painterResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = "Ícone de voltar",
                        tint = Color(0xFF1E1B19)
                    )
                }
                Text(
                    text = "VOLTAR",
                    color = Color(0xFF1E1B19),
                    fontFamily = Roboto,
                    fontSize = 18.sp
                )
}
        }}}