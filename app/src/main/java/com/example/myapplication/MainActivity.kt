import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController() // Navigoinnin ohjain

    Scaffold(
        topBar = {
            MyTopBar(navController = navController) // Yläpalkki (AppBar)
        },
        content = { padding ->
            // Navigaatio eri näyttöjen välillä
            NavHost(navController = navController, startDestination = "main") {
                composable("main") {
                    MainScreen(navController = navController) // Pääsivu
                }
                composable("info") {
                    InfoScreen(navController = navController) // Info-sivu
                }
                composable("settings") {
                    SettingsScreen(navController = navController) // Asetussivu
                }
            }
        }
    )
}

@Composable
fun MyTopBar(navController: NavController) {
    TopAppBar(
        title = { Text("AppBar Otsikko") },
        actions = {
            // Info-painike
            IconButton(onClick = {
                navController.navigate("info")
            }) {
                Icon(Icons.Filled.Info, contentDescription = "Info ikoni")
            }
            // Asetukset-painike
            IconButton(onClick = {
                navController.navigate("settings")
            }) {
                Icon(Icons.Filled.Settings, contentDescription = "Settings ikoni")
            }
        }
    )
}

@Composable
fun MainScreen(navController: NavController) {
    // Pääsisältö, joka näytetään pääsivulla
    Text(text = "Tämä on pääsivu", modifier = Modifier.padding(16.dp))
}

@Composable
fun InfoScreen(navController: NavController) {
    // Info-näyttö
    Text(text = "Tämä on infosivu", modifier = Modifier.padding(16.dp))
}

@Composable
fun SettingsScreen(navController: NavController) {
    // Asetukset-näyttö
    Text(text = "Tämä on asetussivu", modifier = Modifier.padding(16.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}
