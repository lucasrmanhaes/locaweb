package br.com.locaweb.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import br.com.locaweb.R
import br.com.locaweb.components.CustomCard

@Composable
fun CaixaDeEntradaScreen() {
    val Roboto = FontFamily(
        Font(R.font.roboto_regular, FontWeight.Normal),
        Font(R.font.roboto_bold, FontWeight.Bold)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Parte superior da tela
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Icon(
                    painterResource(id = R.drawable.outline_search_24),
                    contentDescription = "Ícone de senha",
                    tint = Color(0xFF1E1B19)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Pesquisar",
                    color = Color(0xFF1E1B19),
                    fontFamily = Roboto,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painterResource(id = R.drawable.outline_edit_24),
                    contentDescription = "Ícone de senha",
                    tint = Color(0xFF1E1B19)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Icon(
                    painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = "Ícone de voltar",
                    tint = Color(0xFF1E1B19)
                )
                Spacer(modifier = Modifier.width(100.dp))
                Text(
                    text = "Entrada",
                    color = Color(0xFF1E1B19),
                    fontFamily = Roboto,
                    fontSize = 18.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Adicionando múltiplos CustomCard
        CustomCard(
            title = "Google Play",
            date = "07 de jun",
            description = "Suas configurações de verifica...",
            imageResource = R.drawable.circulo_laranja,
            iconResource = R.drawable.outline_star_24
        )
        Spacer(modifier = Modifier.height(16.dp)) // Espaçamento entre os cards

        CustomCard(
            title = "App Store",
            date = "08 de jun",
            description = "Atualização disponível...",
            imageResource = R.drawable.circulo_verde,
            iconResource = R.drawable.outline_star_24
        )
        Spacer(modifier = Modifier.height(16.dp)) // Espaçamento entre os cards

        CustomCard(
            title = "Microsoft Store",
            date = "09 de jun",
            description = "Novos aplicativos adicionados...",
            imageResource = R.drawable.circulo_rosa,
            iconResource = R.drawable.outline_star_24
        )

        Spacer(modifier = Modifier.height(16.dp)) // Espaçamento entre os cards

        CustomCard(
            title = "Microsoft Store",
            date = "09 de jun",
            description = "Novos aplicativos adicionados...",
            imageResource = R.drawable.circulo_azul,
            iconResource = R.drawable.outline_star_24
        )
    }
}