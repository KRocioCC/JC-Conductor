package com.karenkotlin.jcconductor.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Conductor(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val ci: String

)