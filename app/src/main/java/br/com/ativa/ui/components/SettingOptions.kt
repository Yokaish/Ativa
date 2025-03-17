package br.com.ativa.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ativa.R
import br.com.ativa.ui.theme.PoppinsSemibold

@Composable
fun SettingOption(
    modifier: Modifier,
    @DrawableRes icon: Int? = null,
    text: String,
    btnType: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon?.let { Icon(painter = painterResource(id = icon), contentDescription = "Ícone de Configuração",
            modifier = modifier.size(24.dp), tint = Color(0xFF45525F)
            ) }
            Text(text = text, color = Color(0xFF45525F), fontSize = 16.sp, fontFamily = PoppinsSemibold)
        }
        when (btnType) {
            "arrow" -> Icon(
                painter = painterResource(id = R.drawable.arrow),
                contentDescription = "Ícone de Flecha",
                tint = Color(0xFF45525F),
                modifier = Modifier.size(18.dp)
            )
            "toggle" -> ToggleBtn(isOn = false, onToggle = {})
        }
    }
}

@Preview
@Composable
fun SettingOptionPrev() {
    SettingOption(modifier = Modifier, text = "Modo Escuro", icon = R.drawable.settings, btnType = "arrow")
}