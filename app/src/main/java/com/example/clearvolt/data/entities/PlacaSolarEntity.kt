package com.example.clearvolt.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "placa_solar")
data class PlacaSolarEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val potencia: Double, // Potência em watts
    val area: Double, // Área em metros quadrados
    val instaladaEm: String, // Data de instalação, pode ser ISO 8601 ou formato padrão
    val limpa: Boolean = false // Indica se a placa foi limpa recentemente
)
