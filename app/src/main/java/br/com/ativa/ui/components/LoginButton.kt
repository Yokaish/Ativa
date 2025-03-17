package br.com.ativa.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import br.com.ativa.ui.theme.PoppinsRegular
import br.com.ativa.ui.theme.PoppinsSemibold

@Composable
fun MainButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    onClick: () -> Unit,
    font: FontFamily,
    heightBtn: Int
) {
    Button(
        modifier = modifier
            .heightIn(min = heightBtn.dp)
            .shadow(elevation = 0.dp, spotColor = Color(0x26FFFFFF), ambientColor = Color(0x26FFFFFF))
        ,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE01257)),
        shape = RoundedCornerShape(size = 10.69767.dp)
    ) {
        text?.let {Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = font,
            color = Color.White,
            textAlign = TextAlign.Center,
        )}
    }
}

@Preview
@Composable
fun MainButtonPreview() {
    MainButton(modifier = Modifier.fillMaxWidth(),text = "Entrar", onClick = {}, font = PoppinsSemibold, heightBtn = 48)
}