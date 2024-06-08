package br.com.locaweb.screens

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.locaweb.R
import br.com.locaweb.components.CustomButtonTelaInicial
import br.com.locaweb.ui.theme.Subtitle
import br.com.locaweb.ui.theme.TelaFundo
import br.com.locaweb.ui.theme.White

@Composable
fun TelaInicialScreen(navController: NavController) {
    val Roboto = FontFamily(
        Font(R.font.roboto_regular, FontWeight.Normal),
        Font(R.font.roboto_bold, FontWeight.Bold)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Parte fixa no topo
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Editar",
                color = Color(0xFF1E1B19),
                fontSize = 18.sp,
                fontFamily = Roboto,
                textDecoration = TextDecoration.Underline

            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painterResource(id = R.drawable.outline_edit_24),
                contentDescription = "Ícone de edição",
                tint = Color(0xFF1E1B19)
            )
        }
        Spacer(modifier = Modifier.height(32.dp))

        // Conteúdo rolável
        LazyColumn {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(Color(0xFFF2F2F7))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        CustomButtonTelaInicial(
                            icon = painterResource(id = R.drawable.ic_inbox),
                            text = "Entrada",
                            onClick = {  navController.navigate("TelaContasDeEmail") }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        CustomButtonTelaInicial(
                            icon = painterResource(id = R.drawable.outline_star_24),
                            text = "Favoritos",
                            onClick = { /*TODO*/ }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        CustomButtonTelaInicial(
                            icon = painterResource(id = R.drawable.outline_send_24),
                            text = "Enviados",
                            onClick = { /*TODO*/ }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        CustomButtonTelaInicial(
                            icon = painterResource(id = R.drawable.outline_delete_24),
                            text = "Excluídos",
                            onClick = { /*TODO*/ }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        CustomButtonTelaInicial(
                            icon = painterResource(id = R.drawable.outline_label_important_24),
                            text = "Importante",
                            onClick = { /*TODO*/ }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        CustomButtonTelaInicial(
                            icon = painterResource(id = R.drawable.outline_draft_24),
                            text = "Rascunhos",
                            onClick = { /*TODO*/ }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        CustomButtonTelaInicial(
                            icon = painterResource(id = R.drawable.outline_report_24),
                            text = "Spam",
                            onClick = { /*TODO*/ }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        CustomButtonTelaInicial(
                            icon = painterResource(id = R.drawable.outline_calendar_today_24),
                            text = "Agenda",
                            onClick = { /*TODO*/ }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        CustomButtonTelaInicial(
                            icon = painterResource(id = R.drawable.outline_settings_24),
                            text = "Configurações",
                            onClick = { /*TODO*/ }
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    navController.navigate("Login")
                }
            ) {
                Icon(
                    painterResource(id = R.drawable.outline_close_24),
                    contentDescription = "Ícone de fechar",
                    tint = Color(0xFF1E1B19)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Sair",
                color = Color(0xFF1E1B19),
                fontSize = 18.sp,
                fontFamily = Roboto
            )
        }
            

        }
    }

