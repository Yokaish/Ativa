package br.com.ativa.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ativa.ui.theme.PoppinsRegular
import br.com.ativa.ui.theme.PoppinsSemibold

@Composable
fun FormInput(
    modifier: Modifier = Modifier,
    label: String,
    alternateLink: String? = null,
    onValueChange: (String) -> Unit,
    value: String,
    keyboardType: KeyboardType,
    @DrawableRes passwordIcon: Int? = null,
    iconModifier: Modifier? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None, // NOVO PARÂMETRO
) {


    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = label,
                fontSize = 16.sp,
                fontFamily = PoppinsRegular,
                fontWeight = FontWeight(400),
                color = Color(0xFF1E1E1E),
                modifier = Modifier.padding(bottom = 14.dp),
            )
            alternateLink?.let {
                Text(
                    text = it,
                    fontFamily = PoppinsSemibold,
                    fontSize = 14.sp,
                    color = Color(0xFFE01257),
                    modifier = Modifier.padding(bottom = 14.dp),
                )
            }
        }
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(48.dp),
            value = value,
            onValueChange = { newValue -> onValueChange(newValue) },
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFCCCCCC),
                unfocusedBorderColor = Color(0xFFCCCCCC),
                cursorColor = Color(0xFFE01257),
                unfocusedTextColor = Color(0xFF1E1E1E),
                focusedTextColor = Color(0xFF1E1E1E)
            ),
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = visualTransformation, // APLICANDO TRANSFORMAÇÃO VISUAL
            trailingIcon = {
                passwordIcon?.let {
                    Icon(
                        painter = painterResource(id = it),
                        contentDescription = "Ícone",
                        modifier = iconModifier!!
                    )
                }
            },
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FormInputPreview() {
    Column(
        modifier = Modifier.padding(30.dp)
    ) {
        FormInput(
            label = "Name",
            value = "",
            onValueChange = {},
            keyboardType = KeyboardType.Text
        )
        FormInput(
            label = "Email address",
            value = "",
            onValueChange = {},
            keyboardType = KeyboardType.Email
        )
        FormInput(
            label = "Password",
            value = "",
            onValueChange = {},
            alternateLink = "Forgot password?",
            keyboardType = KeyboardType.Password
        )
    }
}
