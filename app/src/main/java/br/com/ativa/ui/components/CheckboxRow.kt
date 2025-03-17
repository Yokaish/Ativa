package br.com.ativa.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.CheckboxDefaults
import br.com.ativa.ui.theme.PoppinsRegular

@Composable
fun CheckboxRow(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit = {},
    onTermsClick: () -> Unit,
    annotatedText: AnnotatedString? = null
) {
    var checkedState by remember { mutableStateOf(checked) }


    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = {
                checkedState = it
                onCheckedChange(it)
            },
            colors = CheckboxDefaults.colors(checkedColor = Color(0xFFE01257)),
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = annotatedText!!,
            style = TextStyle(fontSize = 14.sp, fontFamily = PoppinsRegular, color = Color(0xFF777777)),
        )
    }
}

