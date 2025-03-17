package br.com.ativa.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ativa.R

@Composable
fun EmployeeCard(
    @DrawableRes image: Int,
    name: String,
    role: String,
    employData: String
) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
           Row(
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.spacedBy(10.dp)
           ) {
               Image(
                   painter = painterResource(id = image),
                   contentDescription = "Foto do Funcionário",
                   modifier = Modifier
                       .size(46.dp)
                       .clip(shape = RoundedCornerShape(12.dp)),
               )
               Column(modifier = Modifier.padding(0.dp)) {
                     Text(text = name, color =  Color(0xFF45525F), fontSize = 14.sp)
                    Text(text = role, color =  Color(0xFFE01257), fontSize = 12.sp)
                   Text(text = employData, color = Color(0xFF73808C), fontSize = 10.sp)
               }
           }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.notification_ic),
                    contentDescription = "Ícone de Notificação",
                    tint = Color(0xFFE01257),
                    modifier = Modifier.size(20.dp)
                )

                Icon(
                    painter = painterResource(id = R.drawable.account_ic),
                    contentDescription = "Ícone de Perfil",
                    tint = Color(0xFFE01257),
                    modifier = Modifier.size(20.dp)
                )

                Icon(
                    painter = painterResource(id = R.drawable.verified),
                    contentDescription = "Ícone de Verificado",
                    tint = Color(0xFFE01257),
                    modifier = Modifier.size(20.dp)
                )
            }

        }
    }


@Preview
@Composable
fun EmployeeCardPreview() {
    EmployeeCard(
        image = R.drawable.profile_picture,
        role = "Developer",
        name = "Kauã Gomes",
        employData = "Funcionário desde 2025"
    )
}