package uns.pmf.learningjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
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
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        var isOpenedDialog1 by remember {
            mutableStateOf(false)
        }
        var isOpenedDialog2 by remember {
            mutableStateOf(false)
        }
        var message by remember {
            mutableStateOf("")
        }

        if (message.isNotEmpty()) {
            Text(text = message)
        }
        Button(
            onClick = {
                isOpenedDialog1 = true
            }
        ) {
            Text(text = "Dialog 1")
        }
        Button(
            onClick = {
                isOpenedDialog2 = true
            }
        ) {
            Text(text = "Dialog 2")
        }

        if (isOpenedDialog1) {
            AlertDialog(
                onDismissRequest = {
                    isOpenedDialog1 = false
                },
                confirmButton = {
                    Button(
                        onClick = {
                            isOpenedDialog1 = false
                            message = "D1: Confirm"
                        }
                    ) {
                        Text(text = "Confirm")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            isOpenedDialog1 = false
                            message = "D1: Dismiss"
                        }
                    ) {
                        Text(text = "Dismiss")
                    }
                },
                title = {
                    Text(text = "Title")
                },
                text = {
                    Text(text = "Text")
                }
            )
        }
        if (isOpenedDialog2) {
            AlertDialog(
                onDismissRequest = {
                    isOpenedDialog2 = false
                },
                title = {
                    Text(text = "Title")
                },
                text = {
                    Text(text = "Text")
                },
                buttons = {
                    Row(
                        modifier = Modifier.padding(all = 8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                isOpenedDialog2 = false
                                message = "D2: Dismiss"
                            }
                        ) {
                            Text(text = "Dismiss")
                        }
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Example()
}