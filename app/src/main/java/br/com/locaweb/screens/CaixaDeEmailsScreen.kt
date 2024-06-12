package br.com.locaweb.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.locaweb.R
import br.com.locaweb.components.CustomCard

@Composable
fun CaixaDeEmailsScreen(navController: NavController) {
    val Roboto = FontFamily(
        Font(R.font.roboto_regular, FontWeight.Normal),
        Font(R.font.roboto_bold, FontWeight.Bold)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(72.dp))
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Icon(
                    painterResource(id = R.drawable.outline_library_add_24),
                    contentDescription = "Ícone de pesquisar",
                    tint = Color(0xFF1E1B19)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Adicionar nova conta",
                    color = Color(0xFF1E1B19),
                    fontFamily = Roboto,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Icon(
                    painterResource(id = R.drawable.outline_edit_24),
                    contentDescription = "Ícone de pesquisar",
                    tint = Color(0xFF1E1B19)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Editar Contas",
                    color = Color(0xFF1E1B19),
                    fontFamily = Roboto,
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            CustomCard(
                title = "Caixa de entrada Gmail",
                date = "",
                description = "4 emails não lidos",
                imageResource = R.drawable.gmail,
                iconResource = R.drawable.outline_star_24,
                onClick = { navController.navigate("TelaListaEmails/1") }
            )

            Spacer(modifier = Modifier.height(20.dp))

            CustomCard(
                title = "Caixa de entrada Outlook",
                date = "",
                description = "20 emails nao lidos",
                imageResource = R.drawable.outlook,
                iconResource = R.drawable.outline_star_24,
                onClick = { navController.navigate("TelaListaEmails/2") }
            )

            Spacer(modifier = Modifier.height(20.dp))

            CustomCard(
                title = "Caixa de entrada Trabalho",
                date = "",
                description = "0 emails não lidos",
                imageResource = R.drawable.trabalho,
                iconResource = R.drawable.outline_star_24,
                onClick = { navController.navigate("TelaListaEmails/3") }
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Start
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
            }
        }
    }
}