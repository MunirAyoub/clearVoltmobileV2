package com.example.clearvolt.data.repository

import androidx.lifecycle.LiveData
import com.example.clearvolt.data.dao.PlacaSolarDao
import com.example.clearvolt.data.entities.PlacaSolarEntity

class PlacaSolarRepository(private val placaSolarDao: PlacaSolarDao) {

    // Obter todas as placas solares
    val allPlacas: LiveData<List<PlacaSolarEntity>> = placaSolarDao.listarPlacas()

    // Inserir uma nova placa solar
    suspend fun insert(placaSolar: PlacaSolarEntity) {
        placaSolarDao.inserirPlaca(placaSolar)
    }

    // Atualizar uma placa solar existente
    suspend fun update(placaSolar: PlacaSolarEntity) {
        placaSolarDao.atualizarPlaca(placaSolar)
    }

    // Deletar uma placa solar
    suspend fun delete(placaSolar: PlacaSolarEntity) {
        placaSolarDao.deletarPlaca(placaSolar)
    }

    // Marcar uma placa solar como limpa
    suspend fun limparPlaca(id: Int) {
        placaSolarDao.limparPlaca(id)
    }
}
