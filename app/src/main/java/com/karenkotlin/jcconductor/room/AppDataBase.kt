package com.karenkotlin.jcconductor.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.karenkotlin.jcconductor.room.dao.AutoDao
import com.karenkotlin.jcconductor.room.dao.ConductorDao
import com.karenkotlin.jcconductor.room.entity.Auto
import com.karenkotlin.jcconductor.room.entity.Conductor

@Database(
    entities = [Conductor::class,Auto::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun conductorDao(): ConductorDao
    abstract fun autoDao(): AutoDao

}