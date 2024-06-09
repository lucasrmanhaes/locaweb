package br.com.locaweb.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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

@Composable
fun EmailAgendamentoAberto(
    subject: String,
    sender: String,
    date: String,
    time: String,
    location: String,
    body: String,
    onAcceptClick: () -> Unit,
    onDeclineClick: @Composable () -> Unit
) {
    val Roboto = FontFamily(
        Font(R.font.roboto_regular, FontWeight.Normal),
        Font(R.font.roboto_bold, FontWeight.Bold)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Assunto: $subject",
            fontFamily = Roboto,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier.padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.outline_contact_mail_24),
                contentDescription = "Ícone de Remetente",
                tint = Color(0xFF1E1B19),
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = "De: $sender",
                fontFamily = Roboto,
                fontSize = 16.sp
            )
        }

        Row(
            modifier = Modifier.padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.outline_calendar_today_24),
                contentDescription = "Ícone de Data",
                tint = Color(0xFF1E1B19),
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = "Data: $date",
                fontFamily = Roboto,
                fontSize = 16.sp
            )
        }

        Row(
            modifier = Modifier.padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_watch_later_24),
                contentDescription = "Ícone de Horário",
                tint = Color(0xFF1E1B19),
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = "Horário: $time",
                fontFamily = Roboto,
                fontSize = 16.sp
            )
        }

        Row(
            modifier = Modifier.padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.outline_location_on_24),
                contentDescription = "Ícone de Local",
                tint = Color(0xFF1E1B19),
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = "Local: $location",
                fontFamily = Roboto,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = body,
            fontFamily = Roboto,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = onAcceptClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50), // Cor de fundo do botão "Aceitar"
                    contentColor = Color.White // Cor do texto do botão "Aceitar"
                ),
                shape = RoundedCornerShape(10.dp)


            ) {
                Text("Aceitar")
            }

            Button(
                onClick = { onDeclineClick },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE60042), // Cor de fundo do botão "Aceitar"
                    contentColor = Color.White // Cor do texto do botão "Aceitar"
                ),
                shape = RoundedCornerShape(10.dp)

            ) {
                Text("Recusar")
            }
        }
    }
}