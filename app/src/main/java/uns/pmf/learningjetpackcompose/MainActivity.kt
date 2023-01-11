package uns.pmf.learningjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
    SelectionContainer {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "This text is selectable",
                modifier = Modifier.background(Color.Yellow),
                fontSize = 24.sp
            )
            DisableSelection {
                Text(
                    text = "This text is not selectable",
                    modifier = Modifier.background(Color.Gray),
                    fontSize = 24.sp
                )
            }
            Text(
                text = "This text is selectable",
                modifier = Modifier.background(Color.Yellow),
                fontSize = 24.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExamplePreview() {
    Example()
}