package br.com.locaweb.screens

import android.content.Intent
import android.provider.CalendarContract
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.locaweb.R
import br.com.locaweb.components.EmailAgendamentoAberto
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun EmailAbertoScreen(navController: NavController) {
    val Roboto = FontFamily(
        Font(R.font.roboto_regular, FontWeight.Normal),
        Font(R.font.roboto_bold, FontWeight.Bold)
    )

    val options = listOf("Responder", "Responder a todos", "Encaminhar")
    val (expanded, setExpanded) = remember { mutableStateOf(false) }
    var eventAccepted = remember { mutableStateOf(false) }
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Opções",
                    color = Color(0xFF1E1B19),
                    fontSize = 18.sp,
                    fontFamily = Roboto
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painterResource(id = R.drawable.outline_keyboard_arrow_down_24),
                    contentDescription = "Ícone de seleção",
                    tint = Color(0xFF1E1B19),
                    modifier = Modifier.clickable { setExpanded(true) }
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { setExpanded(false) },
                    modifier = Modifier.offset(x = (2.5).dp, y = 2.5.dp)
                ) {
                    options.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(text = option) },
                            onClick = {
                                setExpanded(false)
                                // Implemente a ação correspondente à opção selecionada
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            EmailAgendamentoAberto(
                subject = "Reunião de alinhamento",
                sender = "usuario@gmail.com",
                date = "09/08/2024",
                time = "13:00",
                location = "São Paulo - Brasil",
                body = "Reunião para alinhamento de tarefas da equipe," +
                        " e tecnologias a serem utilizadas no projeto",
                onAcceptClick = {
                    val beginTime = Calendar.getInstance().apply {
                        time = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).parse("09/06/2024 13:00")!!
                    }
                    val endTime = Calendar.getInstance().apply {
                        time = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).parse("09/06/2024 14:00")!!
                    }

                    val intent = Intent(Intent.ACTION_INSERT).apply {
                        data = CalendarContract.Events.CONTENT_URI
                        putExtra(CalendarContract.Events.TITLE, "Reunião de alinhamento")
                        putExtra(CalendarContract.Events.DESCRIPTION, "Reunião para alinhamento de tarefas da equipe, e tecnologias a serem utilizadas no projeto")
                        putExtra(CalendarContract.Events.EVENT_LOCATION, "São Paulo - Brasil")
                        putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.timeInMillis)
                        putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.timeInMillis)
                        putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false)
                        putExtra(CalendarContract.Events.ACCESS_LEVEL, CalendarContract.Events.ACCESS_PRIVATE)
                        putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
                    }
                    context.startActivity(intent)
                    eventAccepted.value = true
                }
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Reunião de alinhamento",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "De: usuario@gmail.com",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "Data: 09/06/2024",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "Horário: 13:00",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "Local: São Paulo - Brasil",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Reunião para alinhamento de tarefas da equipe, e tecnologias a serem utilizadas no projeto",
                        fontSize = 14.sp
                    )
                }
            }

            if (eventAccepted.value) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Button(
                        onClick = {
                            val intent = Intent(Intent.ACTION_VIEW).apply {
                                data = CalendarContract.CONTENT_URI
                            }
                            context.startActivity(intent)
                        }
                    ) {
                        Text("Ver Calendário")
                    }
                }
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomEnd)
        ) {
            Icon(
                painterResource(id = R.drawable.outline_close_24),
                contentDescription = "Ícone de fechar",
                tint = Color(0xFF1E1B19),
                modifier = Modifier
                    .size(32.dp)
                    .clickable {

                            navController.navigate("TelaContasDeEmail")

                    }
            )

            Icon(
                painterResource(id = R.drawable.outline_delete_24),
                contentDescription = "Ícone de lixeira",
                tint = Color(0xFF1E1B19),
                modifier = Modifier
                    .size(32.dp)
                    .clickable { /*TODO*/ }
            )
        }
    }
}