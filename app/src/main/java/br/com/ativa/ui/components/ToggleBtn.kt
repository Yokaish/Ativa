package br.com.ativa.ui.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.spring


@Composable
fun ToggleBtn(
    isOn: Boolean,
    onToggle: (Boolean) -> Unit
) {
    var switchOn by remember { mutableStateOf(isOn) }

    // Anima a posição da bolinha
    val ballOffset by animateDpAsState(
        targetValue = if (switchOn) 24.dp else 2.dp, // Movimenta a bolinha
        animationSpec = spring(stiffness = Spring.StiffnessMedium) // Usa spring corretamente
    )

    Box(
        modifier = Modifier
            .width(50.dp)
            .height(30.dp)
            .clip(RoundedCornerShape(50))
            .background(if (switchOn) Color(0xFFE01257) else Color(0xFF73808C))
            .clickable {
                switchOn = !switchOn
                onToggle(switchOn)
            },
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .offset(x = ballOffset) // Usa o valor animado
                .clip(CircleShape)
                .background(Color.White)
        )
    }
}

@Preview
@Composable
fun AnimatedSwitchPreview() {
    var isOn by remember { mutableStateOf(false) }

    ToggleBtn(isOn = isOn) { newState ->
        isOn = newState
    }
}

