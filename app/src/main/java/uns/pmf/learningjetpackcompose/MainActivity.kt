package uns.pmf.learningjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uns.pmf.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningJetpackComposeTheme {
                Example()
            }
        }
    }
}

@Composable
fun Example() {
    val color = Color(120, 120, 255)
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var sliderState by remember {
            mutableStateOf(0.5f)
        }
        Text(
            text = String.format("%.2f%%", sliderState * 100),
            fontSize = 36.sp
        )
        CircularProgressIndicator(
            progress = sliderState,
            modifier = Modifier.size(100.dp),
            color = color,
            strokeWidth = 20.dp
        )
        Slider(
            value = sliderState,
            onValueChange = {
                sliderState = it
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Example()
}