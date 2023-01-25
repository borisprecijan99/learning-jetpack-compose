package uns.pmf.learningjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import uns.pmf.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningJetpackComposeTheme {
                ScaffoldExample()
            }
        }
    }
}

@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val context = LocalContext.current
    val list = mutableListOf(
        MenuItem("Home", "Go to home screen", Icons.Default.Home),
        MenuItem("Settings", "Go to settings", Icons.Default.Settings),
        MenuItem("Help", "Go to help screen", Icons.Default.Info)
    )
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier,
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Top App Bar")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }
                    ) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu Icon")
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                    }
                    IconButton(
                        onClick = {
                            Toast.makeText(context, "Add Reaction", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.AddReaction,
                            contentDescription = "Add Reaction Icon"
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                cutoutShape = CircleShape
            ) {
                Text(text = "Bottom App Bar")
            }
        },
        snackbarHost = {},
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Toast.makeText(context, "Floating Action Button", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Icon")
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        drawerContent = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f)
                    .background(Color.Yellow),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Header", fontSize = 60.sp)
            }
            LazyColumn {
                items(list) { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                Toast
                                    .makeText(context, "${item.title} clicked", Toast.LENGTH_SHORT)
                                    .show()
                            }
                            .padding(16.dp)
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.contentDescription
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = item.title
                        )
                    }
                }
            }
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        //drawerShape = ,
        //drawerElevation = ,
        //drawerBackgroundColor = ,
        //drawerContentColor = ,
        //drawerScrimColor = ,
        backgroundColor = Color.Yellow,
        //contentColor =
    ) {
        Text(text = "Body")
    }
}

data class MenuItem(
    val title: String,
    val contentDescription: String,
    val icon: ImageVector
)

@Preview(showBackground = true)
@Composable
fun Preview() {
    ScaffoldExample()
}