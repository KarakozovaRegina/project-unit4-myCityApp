package krv.fit.bstu.project_unit4_mycityapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import krv.fit.bstu.project_unit4_mycityapp.ui.CafeApp
import krv.fit.bstu.project_unit4_mycityapp.ui.theme.Projectunit4myCityAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Projectunit4myCityAppTheme {
                Surface {
                    CafeApp()
                }
            }
        }
    }
}
