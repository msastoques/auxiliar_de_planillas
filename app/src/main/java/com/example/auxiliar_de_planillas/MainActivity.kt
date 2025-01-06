package com.example.auxiliar_de_planillas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.auxiliar_de_planillas.ui.theme.Auxiliar_de_planillasTheme
/*Documentación
el objetivo es cargar la lista de estudiantes, luego mostrarlos por curso.
crear lista de asistencia y escribirla en un csv general,
igualmente para actividades por tipo de desempeño, es decir: cognitovo,
procedimental, y actitudinal, y que se guarden en el mismo csv.

ese documento  se debe exportar y pegar los datos en Google Sheets para generar,
el informe final. Pueden existir datos repetidos y es porque el estudiante puede mejorar la
nota o presentar la tarea y eso genera un registro nuevo, pero en Google
Sheets siempre tomara el ultimo dato



*/
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Auxiliar_de_planillasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
    private val estudiantes: MutableList<Estudiante> = mutableListOf()
    private fun readData(){
        /*val EjemploEstudiante1 = Estudiante(
            activo = true,
            documento = "123456789",
            grado = 11,
            sede = "Sede Principal",
            nombre = "Mauricio Sastoque"
        )*/
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Auxiliar_de_planillasTheme {
        Greeting("Android")
    }
}