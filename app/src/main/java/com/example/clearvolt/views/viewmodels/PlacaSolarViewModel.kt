package com.example.clearvolt.views.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.clearvolt.data.AppDatabase
import com.example.clearvolt.data.entities.PlacaSolarEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PlacaSolarViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = AppDatabase.getDatabase(application).placaSolarDao()

    val placas: LiveData<List<PlacaSolarEntity>> = dao.listarPlacas()

    /**
     * Insere uma nova placa solar no banco de dados.
     */
    fun inserirPlaca(placa: PlacaSolarEntity) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    dao.inserirPlaca(placa)
                }
            } catch (e: Exception) {
                e.printStackTrace() // Log de erro para depuração
            }
        }
    }

    /**
     * Atualiza os dados de uma placa solar existente.
     */
    fun atualizarPlaca(placa: PlacaSolarEntity) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    dao.atualizarPlaca(placa)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    /**
     * Deleta uma placa solar do banco de dados.
     */
    fun deletarPlaca(placa: PlacaSolarEntity) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    dao.deletarPlaca(placa)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    /**
     * Marca uma placa solar como limpa, com base no ID.
     */
    fun limparPlaca(id: Int) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    dao.limparPlaca(id)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
