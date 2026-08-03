package com.karenkotlin.jcconductor.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.karenkotlin.jcconductor.room.entity.Auto
import kotlinx.coroutines.flow.Flow

@Dao
interface AutoDao {

    @Query("SELECT * FROM Auto")
    fun getAllAutos(): Flow<List<Auto>>

    //FK
    @Query("SELECT * FROM Auto WHERE conductorId = :id")
    fun getAutosByConductor(id: Int): Flow<List<Auto>>

    @Insert
    suspend fun insertAuto(auto: Auto)

    @Update
    suspend fun updateAuto(auto: Auto)

    @Delete
    suspend fun deleteAuto(auto: Auto)

}