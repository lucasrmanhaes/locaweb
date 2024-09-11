package br.com.locaweb.screens

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TelaConfiguracoesScreen(
    telaConfiguracoesViewModel: TelaConfiguracoesViewModel,
    navController: NavController
) {
    var selectedTheme by remember { mutableStateOf("light") } // Estado para o tema atual

    // Observa mudanças de tema salvas com sucesso
    val themeSaved by telaConfiguracoesViewModel.themeSaved.observeAsState()

    // Troca o tema caso ele seja salvo com sucesso
    themeSaved?.let {
        selectedTheme = it // Atualiza o tema selecionado
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Escolha o Tema:",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    RadioButton(
                        selected = selectedTheme == "light",
                        onClick = { selectedTheme = "light" }
                    )
                    Text(text = "Tema Claro")
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    RadioButton(
                        selected = selectedTheme == "dark",
                        onClick = { selectedTheme = "dark" }
                    )
                    Text(text = "Tema Escuro")
                }
            }
        }

        FloatingActionButton(
            onClick = {
                telaConfiguracoesViewModel.gravar(selectedTheme, navController.context)
            },
            containerColor = Color.Blue,
            contentColor = Color.White,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(Icons.Filled.Send, contentDescription = "Salvar")
        }
    }
}

