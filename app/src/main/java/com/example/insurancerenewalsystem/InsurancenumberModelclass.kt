package com.example.insurancerenewalsystem

class InsurancenumberModelclass {
    var DTT_EXPIRY_DATE: String = ""
    var DTT_INCEPTION_DATE: String = ""
    var DTT_ISSUE_DATE: String = ""
    var EMAIL_ID: String = ""
    var MOB_NUM: String = ""
    var NUM_EX_COVERAGE_AMT: String = ""
    var NUM_EX_COVERAGE_PREMIUM: String = ""
    var NUM_EX_COVERAGE_TOT: String = ""
    var NUM_MANUFACTURE_YEAR: String = ""
    var NUM_MODEL_ID: String = ""
    var NUM_SERVICE_TAX_AMOUNT: String = ""
    var NUM_SERVICE_TAX_ID: String = ""
    var NUM_SERVICE_TAX_PERCENT: String = ""
    var VCH_CHASSIS_NO: String = ""
    var VCH_ENGINE_NO: String = ""
    var VCH_INSURED_NAME: String = ""
    var VCH_VEHICLE_NO: String = ""

    var VCH_POLICY_NO: String = ""
var VCH_INSURED_AMOUNT:String=""

    constructor() {

    }

    constructor(
        DTT_EXPIRY_DATE: String,
        DTT_INCEPTION_DATE: String,
        DTT_ISSUE_DATE: String,
        EMAIL_ID: String,
        MOB_NUM: String,
        NUM_EX_COVERAGE_AMT: String,
        NUM_EX_COVERAGE_PREMIUM: String,
        NUM_EX_COVERAGE_TOT: String,
        NUM_MANUFACTURE_YEAR: String,
        NUM_MODEL_ID: String,
        NUM_SERVICE_TAX_AMOUNT: String,
        NUM_SERVICE_TAX_ID: String,
        NUM_SERVICE_TAX_PERCENT: String,
        VCH_CHASSIS_NO: String,
        VCH_ENGINE_NO: String,
        VCH_INSURED_NAME: String,
        VCH_VEHICLE_NO: String,
        VCH_POLICY_NO: String,
        VCH_INSURED_AMOUNT:String
    ) {
        this.DTT_EXPIRY_DATE = DTT_EXPIRY_DATE
        this.DTT_INCEPTION_DATE = DTT_INCEPTION_DATE
        this.DTT_ISSUE_DATE = DTT_ISSUE_DATE
        this.EMAIL_ID = EMAIL_ID
        this.MOB_NUM = MOB_NUM
        this.NUM_EX_COVERAGE_AMT = NUM_EX_COVERAGE_AMT
        this.NUM_EX_COVERAGE_PREMIUM = NUM_EX_COVERAGE_PREMIUM
        this.NUM_EX_COVERAGE_TOT = NUM_EX_COVERAGE_TOT
        this.NUM_MANUFACTURE_YEAR = NUM_MANUFACTURE_YEAR
        this.NUM_MODEL_ID = NUM_MODEL_ID
        this.NUM_SERVICE_TAX_AMOUNT = NUM_SERVICE_TAX_AMOUNT
        this.NUM_SERVICE_TAX_ID = NUM_SERVICE_TAX_ID
        this.NUM_SERVICE_TAX_PERCENT = NUM_SERVICE_TAX_PERCENT
        this.VCH_CHASSIS_NO = VCH_CHASSIS_NO
        this.VCH_ENGINE_NO = VCH_ENGINE_NO
        this.VCH_INSURED_NAME = VCH_INSURED_NAME
        this.VCH_VEHICLE_NO = VCH_VEHICLE_NO
        this.VCH_POLICY_NO = VCH_POLICY_NO
        this.VCH_INSURED_AMOUNT=VCH_INSURED_AMOUNT
    }


}