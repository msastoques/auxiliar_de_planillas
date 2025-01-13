package com.example.auxiliar_de_planillas

import android.content.Context
import android.os.Bundle
import android.util.Log
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
import java.io.BufferedReader
import java.io.InputStreamReader

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
//        Log.d("MiEtiqueta", "Hola Mundo 2 desde Logcat")
        val listaEstudiantes = leerCsvComoEstudiantes(this, R.raw.data)

        // Mostrar los estudiantes en el Logcat
        listaEstudiantes.forEach { estudiante ->
            Log.d("Estudiante", "Activo: ${estudiante.activo}, Documento: ${estudiante.id}, Grado: ${estudiante.grado}, Sede: ${estudiante.sede}, Apellidos y Nombres: ${estudiante.apellidosYNombres}")
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

fun leerCsvComoEstudiantes(context: Context, resourceId: Int): List<Estudiante> {
    val estudiantes = mutableListOf<Estudiante>()

    context.resources.openRawResource(resourceId).use { inputStream ->
        BufferedReader(InputStreamReader(inputStream, Charsets.ISO_8859_1)).use { reader ->
            // Saltar la cabecera del CSV
            reader.lineSequence().drop(1).forEach { linea ->
                // Dividir la línea por comas
                val valores = linea.split(",")

                // Crear un objeto Estudiante usando los valores de cada línea
                val estudiante = Estudiante(
                    activo = valores[0].toBoolean(),
                    id = valores[1],
                    grado = valores[2].toInt(),
                    sede = valores[3],
                    apellidosYNombres = valores[4]
                )
                estudiantes.add(estudiante)
            }
        }
    }

    return estudiantes
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