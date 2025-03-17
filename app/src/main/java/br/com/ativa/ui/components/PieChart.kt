package br.com.ativa.ui.components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ativa.ui.theme.PoppinsRegular
import br.com.ativa.ui.theme.PoppinsSemibold

@Composable
fun PieChart(
    data: Map<String, Int>,
    radiusOuter: Dp = 60.dp,
    chartBarWidth: Dp = 7.dp,
    animDuration: Int = 1000,
    centerText: String = "",
    stuffColor: Color
) {
    val totalSum = data.values.sum()
    val floatValue = data.values.map { 360 * it.toFloat() / totalSum.toFloat() }

    // Lista fixa de cores para os setores do gráfico
    val colors = listOf(
        stuffColor,
        Color(0xFFF5F6FA),
    )

    var animationPlayed by remember { mutableStateOf(false) }
    var lastValue = 0f

    // Animação de tamanho
    val animateSize by animateFloatAsState(
        targetValue = if (animationPlayed) radiusOuter.value * 2f else 0f,
        animationSpec = tween(durationMillis = animDuration, easing = LinearOutSlowInEasing)
    )

    // Animação de rotação
    val rotation by animateFloatAsState(
        targetValue = if (animationPlayed) 360f else 0f,
        animationSpec = tween(durationMillis = animDuration, easing = LinearOutSlowInEasing)
    )

    LaunchedEffect(key1 = true) { animationPlayed = true }

    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(animateSize.dp)
                .rotate(rotation) // Aplica a rotação animada
        ) {
            floatValue.forEachIndexed { index, value ->
                drawArc(
                    color = colors[index % colors.size],
                    startAngle = lastValue,
                    sweepAngle = value,
                    useCenter = false,
                    style = Stroke(chartBarWidth.toPx(), cap = StrokeCap.Butt)
                )
                lastValue += value
            }
        }

        Text(
            text = centerText,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = PoppinsSemibold,
            color = Color(0xFFE01257)
        )
    }
}





@Composable
fun DetailsPieChart(
    data: Map<String, Int>,
    colors: List<Color>
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        data.values.forEachIndexed { index, value ->
            DetailsPieChartItem(
                data = Pair(data.keys.elementAt(index), value),
                color = colors[index]
            )
        }
    }
}

@Composable
fun DetailsPieChartItem(
    data: Pair<String, Int>,
    height: Dp = 15.dp,
    width: Dp = 30.dp,
    color: Color
) {

    Surface(
        color = Color.Transparent
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .background(
                        color = color,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .height(height)
                    .width(width)
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = data.first,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color(0xFF1A1F24),
                    fontFamily = PoppinsSemibold
                )
            }

        }

    }

}
