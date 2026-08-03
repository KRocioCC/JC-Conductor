package com.karenkotlin.jcconductor.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.karenkotlin.jcconductor.room.entity.Conductor
import kotlinx.coroutines.flow.Flow

@Dao
interface ConductorDao {

    @Query("SELECT * FROM Conductor")
    fun getAllConductors(): Flow<List<Conductor>>

    @Insert
    suspend fun insertConductor(conductor: Conductor)

    @Update
    suspend fun updateConductor(conductor: Conductor)

    @Delete
    suspend fun deleteConductor(conductor: Conductor)

}