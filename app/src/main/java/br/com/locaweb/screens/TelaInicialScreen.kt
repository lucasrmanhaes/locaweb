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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.locaweb.R
import br.com.locaweb.components.CustomButtonTelaInicial
import br.com.locaweb.ui.theme.Subtitle
import br.com.locaweb.ui.theme.TelaFundo
import br.com.locaweb.ui.theme.White

@Composable
fun TelaInicialScreen() {

    Box(
        modifier = Modifier.padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Text(
                    text = "Editar",
                    color = Color(0xFF1E1B19)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = "Ícone de senha",
                    tint = Color(0xFF1E1B19)
                )
        }
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(Color(0xFFF2F2F7))

            ) {
                Column(modifier = Modifier
                    .padding(16.dp)
                ) {
                    CustomButtonTelaInicial(
                        icon = painterResource(id = R.drawable.ic_inbox),
                        text = "Entrada",
                        onClick = { /*TODO*/
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CustomButtonTelaInicial(
                        icon = painterResource(id = R.drawable.outline_star_24),
                        text = "Favoritos",
                        onClick = { /*TODO*/
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CustomButtonTelaInicial(
                        icon = painterResource(id = R.drawable.outline_send_24),
                        text = "Enviados",
                        onClick = { /*TODO*/
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CustomButtonTelaInicial(
                        icon = painterResource(id = R.drawable.outline_delete_24),
                        text = "Excluídos",
                        onClick = { /*TODO*/
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CustomButtonTelaInicial(
                        icon = painterResource(id = R.drawable.outline_label_important_24),
                        text = "Importante",
                        onClick = { /*TODO*/
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CustomButtonTelaInicial(
                        icon = painterResource(id = R.drawable.outline_draft_24),
                        text = "Rascunhos",
                        onClick = { /*TODO*/
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CustomButtonTelaInicial(
                        icon = painterResource(id = R.drawable.outline_report_24),
                        text = "Entrada",
                        onClick = { /*TODO*/
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CustomButtonTelaInicial(
                        icon = painterResource(id = R.drawable.outline_calendar_today_24),
                        text = "Entrada",
                        onClick = { /*TODO*/
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CustomButtonTelaInicial(
                        icon = painterResource(id = R.drawable.outline_settings_24),
                        text = "Entrada",
                        onClick = { /*TODO*/
                        }
                    )


        }
    }
}
    }
}