package uns.pmf.learningjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                Toast.makeText(context, "onClick", Toast.LENGTH_SHORT).show()
            },
            //enabled = false,
            border = BorderStroke(2.dp, Color.Blue),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                disabledBackgroundColor = Color.Green
            ),
            contentPadding = PaddingValues(all = 20.dp)
        ) {
            Text(text = "Button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Example()
}