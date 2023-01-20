package uns.pmf.learningjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var isChecked by remember {
            mutableStateOf(false)
        }
        var isEnabled by remember {
            mutableStateOf(true)
        }
        Text(text = "Is checked: $isChecked")
        Text(text = "Is enabled: $isEnabled")
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Checkbox")
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                },
                enabled = isEnabled
            )
        }
        Button(
            onClick = {
                isEnabled = !isEnabled
            }
        ) {
            Text(text = if (isEnabled) "Disable" else "Enable")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Example()
}