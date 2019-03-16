package com.example.insurancerenewalsystem.Database.Dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.insurancerenewalsystem.Database.Table.PolicyNumberTable

@Dao
interface PolicyNumberTableDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(PolicyNumberTable: PolicyNumberTable)

    @Query("SELECT * FROM PolicyNumberTable")
    fun getAll(): List<PolicyNumberTable>


    @Query("SELECT * FROM PolicyNumberTable WHERE VCH_POLICY_NO LIKE :VCH_POLICY_NO")
    fun PolicynumberSearch(VCH_POLICY_NO:String): List<PolicyNumberTable>

}