package com.karenkotlin.jcconductor.room.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karenkotlin.jcconductor.room.RoomApp
import com.karenkotlin.jcconductor.room.entity.Conductor
import kotlinx.coroutines.launch

class ConductorViewModel : ViewModel() {
    private val dao = RoomApp.db.conductorDao()

    // Lista
    val conductores = dao.getAllConductors()

    // Insertar
    fun addConductor(conductor: Conductor) {
        viewModelScope.launch {
            dao.insertConductor(conductor)
        }
    }

    // Eliminar
    fun deleteConductor(conductor: Conductor) {
        viewModelScope.launch {
            dao.deleteConductor(conductor)
        }
    }

    // Actualizar
    fun updateConductor(conductor: Conductor) {
        viewModelScope.launch {
            dao.updateConductor(conductor)
        }
    }
}