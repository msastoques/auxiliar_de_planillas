package com.example.auxiliar_de_planillas

data class Estudiante(
    val activo: Boolean,     // TRUE o FALSE
    val id: String,   // Texto
    val grado: Int,          // Entero
    val sede: String,        // Texto
    val apellidosYNombres : String       // Texto
)