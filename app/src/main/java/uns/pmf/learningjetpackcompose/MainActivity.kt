package uns.pmf.learningjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import uns.pmf.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningJetpackComposeTheme {
                //TextExample1(text = "Text in Jetpack Compose")
                TextExample2()
            }
        }
    }
}

@Composable
fun TextExample1(text: String) {
    val context = LocalContext.current
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.error)
            .border(1.dp, Color.Blue)
            .padding(4.dp)
            .clickable {
                Toast
                    .makeText(context, "Text is clicked!", Toast.LENGTH_SHORT)
                    .show()
            },
        color = MaterialTheme.colors.onError,
        fontSize = 36.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily.SansSerif,
        letterSpacing = 5.sp,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center,
        lineHeight = 2.em,
        //overflow = TextOverflow.Ellipsis,
        //maxLines = 1
    )
}

@Composable
fun TextExample2() {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Red)) {
                append("Text")
            }
            append(" ")
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("in")
            }
            append(" ")
            withStyle(style = SpanStyle(color = Color.Green, fontWeight = FontWeight.Bold)) {
                append("Jetpack Compose")
            }
        },
        fontSize = 36.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun FirstExamplePreview() {
    TextExample1(text = "Text in Jetpack Compose")
}

@Preview(showBackground = true)
@Composable
fun SecondExamplePreview() {
    TextExample2()
}