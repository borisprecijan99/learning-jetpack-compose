package uns.pmf.learningjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
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
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_phone_android_24),
            contentDescription = "First image",
            modifier = Modifier.size(100.dp),
            alignment = Alignment.CenterEnd,
            contentScale = ContentScale.None,
            alpha = 0.3f
        )
        Image(
            imageVector = Icons.Default.Image,
            contentDescription = "Second image",
            modifier = Modifier.size(100.dp),
            alignment = Alignment.TopStart,
            contentScale = ContentScale.None
        )
        Image(
            bitmap = ImageBitmap.imageResource(id = R.drawable.jetpack_compose_icon),
            contentDescription = "Third image"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Example()
}