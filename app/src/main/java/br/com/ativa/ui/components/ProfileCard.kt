package br.com.ativa.ui.components

import android.provider.ContactsContract.Profile
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ativa.R
import br.com.ativa.ui.theme.PoppinsRegular
import br.com.ativa.ui.theme.PoppinsSemibold

@Composable
fun ProfileCard(modifier: Modifier, username: String) {
    Column(
        modifier = modifier.fillMaxWidth() // O Column ocupa toda a largura
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(), // O Card também ocupa toda a largura
            shape = RoundedCornerShape(size = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF5F6FA) // Cor de fundo do Card
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), // Padding interno no Column
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_picture),
                    contentDescription = "Foto de Perfil",
                    modifier = Modifier.size(80.dp)
                )
                Text(
                    text = username,
                    fontSize = 16.sp,
                    fontFamily = PoppinsSemibold,
                    color = Color(0xFF45525F)
                )
                Text(
                    text = "Mobile Developer",
                    fontSize = 12.sp,
                    fontFamily = PoppinsSemibold,
                    color = Color(0xFF45525F)
                )
            }
        }
    }
}


@Preview
@Composable
fun ProfileCardPreview() {
    ProfileCard(modifier = Modifier, username = "Kauã Gomes")
}