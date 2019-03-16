package com.example.insurancerenewalsystem.Database.Table

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "PolicyNumberTable")
class PolicyNumberTable
{
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    @ColumnInfo(name = "DTT_EXPIRY_DATE")
    var DTT_EXPIRY_DATE: String? = null

    @ColumnInfo(name = "DTT_INCEPTION_DATE")
    var DTT_INCEPTION_DATE: String? = null

    @ColumnInfo(name = "DTT_ISSUED_DATE")
    var DTT_ISSUE_DATE: String? = null

    @ColumnInfo(name = "EMAIL_ID")
    var EMAIL_ID: String? = null

    @ColumnInfo(name = "MOB_NUM")
    var MOB_NUM: String? = null

    @ColumnInfo(name = "NUM_EX_COVERAGE_AMT")
    var NUM_EX_COVERAGE_AMT: String? = null

    @ColumnInfo(name = "NUM_EX_COVERAGE_PREMIUM")
    var NUM_EX_COVERAGE_PREMIUM: String? = null

    @ColumnInfo(name = "NUM_EX_COVERAGE_TOT")
    var NUM_EX_COVERAGE_TOT: String? = null

    @ColumnInfo(name = "NUM_MANUFACTURE_YEAR")
    var NUM_MANUFACTURE_YEAR: String? = null

    @ColumnInfo(name = "NUM_MODEL_ID")
    var NUM_MODEL_ID: String? = null

    @ColumnInfo(name = "NUM_SERVICE_TAX_AMOUNT")
    var NUM_SERVICE_TAX_AMOUNT: String? = null

    @ColumnInfo(name = "NUM_SERVICE_TAX_ID")
    var NUM_SERVICE_TAX_ID: String? = null

    @ColumnInfo(name = "NUM_SERVICE_TAX_PERCENT")
    var NUM_SERVICE_TAX_PERCENT: String? = null

    @ColumnInfo(name = "VCH_CHASSIS_NO")
    var VCH_CHASSIS_NO: String? = null

    @ColumnInfo(name = "VCH_ENGINE_NO")
    var VCH_ENGINE_NO: String? = null

    @ColumnInfo(name = "VCH_INSURED_NAME")
    var VCH_INSURED_NAME: String? = null

    @ColumnInfo(name = "VCH_VEHICLE_NO")
    var VCH_VEHICLE_NO: String? = null

    @ColumnInfo(name = "VCH_POLICY_NO")
    var VCH_POLICY_NO: String? = null

    @ColumnInfo(name = "VCH_INSURED_AMOUNT")
    var VCH_INSURED_AMOUNT: String? = null

}