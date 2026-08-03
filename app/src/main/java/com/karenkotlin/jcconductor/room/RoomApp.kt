package com.karenkotlin.jcconductor.room
import android.app.Application
import androidx.room.Room

class RoomApp : Application() {

    companion object {
        lateinit var db: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "transporte_database"
        ).build()
    }
}