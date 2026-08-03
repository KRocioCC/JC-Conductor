package com.karenkotlin.jcconductor.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Auto(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val marca:String,
    //fk
    val conductorId:Long
)
