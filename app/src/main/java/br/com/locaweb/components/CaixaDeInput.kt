package br.com.locaweb.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaDeInput(
    label: String,
    value: String,
    keyboardType: KeyboardType,
    modifier: Modifier,
    atualizarValor:(String) -> Unit
){

    OutlinedTextField(
        value = value,
        onValueChange = atualizarValor,
        modifier = modifier,
        label = {
            Text(
                text = label,
                color = MaterialTheme.colorScheme.secondary // Cor do label
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        textStyle = TextStyle(
            color = MaterialTheme.colorScheme.secondary // Cor do texto do input
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.primary, // Cor da borda quando focada
            unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f), // Cor da borda quando não focada
            cursorColor = MaterialTheme.colorScheme.primary // Cor do cursor
        )
    )


}