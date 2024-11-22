package com.example.clearvolt.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.clearvolt.data.entities.PlacaSolarEntity

@Dao
interface PlacaSolarDao {

    /**
     * Insere uma nova placa solar no banco de dados.
     * Em caso de conflito (mesmo ID), substitui o registro existente.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserirPlaca(placa: PlacaSolarEntity)

    /**
     * Atualiza uma placa solar existente no banco de dados.
     */
    @Update
    suspend fun atualizarPlaca(placa: PlacaSolarEntity)

    /**
     * Deleta uma placa solar do banco de dados.
     */
    @Delete
    suspend fun deletarPlaca(placa: PlacaSolarEntity)

    /**
     * Lista todas as placas solares no banco de dados.
     * Retorna os resultados como um `LiveData`.
     */
    @Query("SELECT * FROM placa_solar")
    fun listarPlacas(): LiveData<List<PlacaSolarEntity>>

    /**
     * Marca uma placa solar como limpa, atualizando o campo `limpa` para `1`.
     */
    @Query("UPDATE placa_solar SET limpa = 1 WHERE id = :id")
    suspend fun limparPlaca(id: Int)

    /**
     * Encontra uma placa solar pelo ID.
     */
    @Query("SELECT * FROM placa_solar WHERE id = :id")
    suspend fun buscarPlacaPorId(id: Int): PlacaSolarEntity?
}
