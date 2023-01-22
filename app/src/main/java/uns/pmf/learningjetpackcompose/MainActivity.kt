package uns.pmf.learningjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            onClick = {
                Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
            }
        ) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Icon description")
        }

        var checked by remember {
            mutableStateOf(false)
        }
        IconToggleButton(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        ) {
            val tint by animateColorAsState(
                if (checked) Color.Red else Color.Gray
            )
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Icon description",
                tint = tint
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Example()
}