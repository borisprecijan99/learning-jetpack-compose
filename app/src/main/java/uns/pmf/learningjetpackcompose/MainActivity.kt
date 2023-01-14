package uns.pmf.learningjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    Row(
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        var switchState by remember {
            mutableStateOf(false)
        }
        Switch(
            checked = switchState,
            onCheckedChange = {
                switchState = it
            }
        )
        Spacer(modifier = Modifier.padding(horizontal = 30.dp))
        Text(text = "Switch state: $switchState")
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Example()
}