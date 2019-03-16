package com.example.insurancerenewalsystem.Database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.insurancerenewalsystem.Database.Dao.PolicyNumberTableDao
import com.example.insurancerenewalsystem.Database.Table.PolicyNumberTable

@Database(
    entities = [(PolicyNumberTable::class)], version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun PolicyNumberTableDao(): PolicyNumberTableDao
}