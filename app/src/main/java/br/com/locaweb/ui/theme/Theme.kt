package br.com.locaweb.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
        primary = Color(color = 0xFFE60042),
        secondary = Color(color = 0xFF707070),
        tertiary = Color(color = 0xFFe5e5e5),
        background = Color(color = 0xFF0C1317)
)

private val LightColorScheme = lightColorScheme(
        primary = Color(color = 0xFFE60042),
        secondary = Color(color = 0xFF707070),
        tertiary = Color(color = 0xFF707070),
        background = Color(0xFFe5e5e5)
)

@Composable
fun LocawebTheme(darkTheme: Boolean = false, content: @Composable () -> Unit) {
        val colors = if (darkTheme) {
                DarkColorScheme
        } else {
                LightColorScheme
        }

        MaterialTheme(
                colorScheme = DarkColorScheme,
                typography = Typography,
                content = content
        )
}
