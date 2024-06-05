package br.com.locaweb.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CaixaDeEntrada(
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
            Text(text = label)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )

    )

}