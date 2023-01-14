package uns.pmf.learningjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uns.pmf.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningJetpackComposeTheme {
                Example1()
            }
        }
    }
}

@Composable
fun Example1() {
    val scrollState = rememberScrollState()
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(scrollState),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0..30) {
            Text(
                text = "$i",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun Example2() {
    Row(
        modifier = Modifier
            .background(Color.Yellow)
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Item 1",
            modifier = Modifier.background(Color.Red)
        )
        Text(
            text = "Item 2",
            modifier = Modifier.background(Color.Green)
        )
        Text(
            text = "Item 3",
            modifier = Modifier.background(Color.Blue)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview1() {
    Example1()
}

@Preview(showBackground = true)
@Composable
fun Preview2() {
    Example2()
}