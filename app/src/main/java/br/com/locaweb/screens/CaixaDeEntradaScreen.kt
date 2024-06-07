// CaixaDeEntradaScreen.kt

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import br.com.locaweb.local_storage.Email
import br.com.locaweb.local_storage.emailList
import kotlinx.coroutines.delay

@Composable
fun CaixaDeEntradaScreen(navController: NavController) {
    val Roboto = FontFamily(
        Font(R.font.roboto_regular, FontWeight.Normal),
        Font(R.font.roboto_bold, FontWeight.Bold)
    )

    val emailsToShow = remember { mutableStateListOf<Email>() }
    val currentEmailIndex = remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (currentEmailIndex.value < emailList.size) {
            delay(3000) // Aguarda 3 segundos antes de exibir o próximo e-mail
            emailsToShow.add(emailList[currentEmailIndex.value])
            currentEmailIndex.value++
        }
    }

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
                    contentDescription = "Ícone de pesquisar",
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
                    contentDescription = "Ícone de editar",
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
                IconButton(
                    onClick = {
                        navController.navigate("TelaInicial")
                    }){
                Icon(
                    painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = "Ícone de voltar",
                    tint = Color(0xFF1E1B19)
                )}
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

        // Listagem dos e-mails
        emailsToShow.forEach { email ->
            CustomCard(
                title = email.title,
                date = email.date,
                description = email.description,
                imageResource = email.imageResource,
                iconResource = email.iconResource
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}