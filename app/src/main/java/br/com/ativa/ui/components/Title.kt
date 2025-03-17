package br.com.ativa.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import br.com.ativa.ui.theme.PoppinsRegular
import br.com.ativa.ui.theme.PoppinsSemibold

@Composable
fun Title(title: String, subtitle: String? = null) {
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = title, fontSize = 20.sp, fontFamily = PoppinsSemibold, color = Color(0xFF1A1F24))
        subtitle?.let { Text(text = subtitle, fontSize = 14.sp, fontFamily = PoppinsRegular, color = Color(0xFF1A1F24), modifier = Modifier.fillMaxWidth()) }
    }
}