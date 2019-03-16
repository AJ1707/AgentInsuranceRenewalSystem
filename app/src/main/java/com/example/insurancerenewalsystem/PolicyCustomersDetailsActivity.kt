package com.example.insurancerenewalsystem

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.Toolbar
import android.util.Log

class PolicyCustomersDetailsActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var ExpirydateTxt: AppCompatTextView
    lateinit var inceptionDateTxt: AppCompatTextView
    lateinit var issuedDateTxt: AppCompatTextView
    lateinit var emailTxt: AppCompatTextView
    lateinit var mobilenumberTxt: AppCompatTextView
    lateinit var numcoverageamtTxt: AppCompatTextView
    lateinit var numberexcoveragepremiumTxt: AppCompatTextView
    lateinit var numberexcoveragetotTxt: AppCompatTextView
    lateinit var numbermanufacturingyearTxt: AppCompatTextView
    lateinit var numbermodelidTxt: AppCompatTextView
    lateinit var numberservicetaxamountTxt: AppCompatTextView
    lateinit var numberservicetaxpercent: AppCompatTextView
    lateinit var numberservicetaxidTxt: AppCompatTextView
    lateinit var vchchassisno: AppCompatTextView
    lateinit var vchenginenumberTxt: AppCompatTextView
    lateinit var vchinsurednameTxt: AppCompatTextView
    lateinit var vchvehiclenumberTxt: AppCompatTextView
    lateinit var vchpolicynumberTxt: AppCompatTextView
    lateinit var totalamountTxt: AppCompatTextView
    lateinit var vchinsuranceamountTxt: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_policy_customers_details)

        vchpolicynumberTxt = findViewById(R.id.vchpolicynumberTxt) as AppCompatTextView
        vchpolicynumberTxt.setText(intent.getStringExtra("VCH_POLICY_NO"))

        toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.setBackgroundColor(resources.getColor(R.color.appcolor))
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.setTitle(vchpolicynumberTxt.text.toString())
        toolbar.setNavigationIcon(resources.getDrawable(R.drawable.ic_backarrow))
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, PolicyNumberSearchActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

        ExpirydateTxt = findViewById(R.id.ExpirydateTxt) as AppCompatTextView
        inceptionDateTxt = findViewById(R.id.inceptionDateTxt) as AppCompatTextView
        issuedDateTxt = findViewById(R.id.issuedDateTxt) as AppCompatTextView
        emailTxt = findViewById(R.id.emailTxt) as AppCompatTextView
        mobilenumberTxt = findViewById(R.id.mobilenumberTxt) as AppCompatTextView
        numcoverageamtTxt = findViewById(R.id.numcoverageamtTxt) as AppCompatTextView
        numberexcoveragepremiumTxt = findViewById(R.id.numberexcoveragepremiumTxt) as AppCompatTextView
        numberexcoveragetotTxt = findViewById(R.id.numberexcoveragetotTxt) as AppCompatTextView
        numbermanufacturingyearTxt = findViewById(R.id.numbermanufacturingyearTxt) as AppCompatTextView
        numbermodelidTxt = findViewById(R.id.numbermodelidTxt) as AppCompatTextView
        numberservicetaxamountTxt = findViewById(R.id.numberservicetaxamountTxt) as AppCompatTextView
        numberservicetaxpercent = findViewById(R.id.numberservicetaxpercent) as AppCompatTextView
        numberservicetaxidTxt = findViewById(R.id.numberservicetaxidTxt) as AppCompatTextView
        vchchassisno = findViewById(R.id.vchchassisno) as AppCompatTextView
        vchenginenumberTxt = findViewById(R.id.vchenginenumberTxt) as AppCompatTextView
        vchinsurednameTxt = findViewById(R.id.vchinsurednameTxt) as AppCompatTextView
        vchvehiclenumberTxt = findViewById(R.id.vchvehiclenumberTxt) as AppCompatTextView
        totalamountTxt = findViewById(R.id.totalamountTxt) as AppCompatTextView
        vchinsuranceamountTxt = findViewById(R.id.vchinsuranceamountTxt) as AppCompatTextView

        getDetails()
        var InsuranceAmount: Double = vchinsuranceamountTxt.text.toString().trim().toDouble()
        var Amount: Double =0.05 * InsuranceAmount

        Log.e("vchinsuranceamountTxt", vchinsuranceamountTxt.text.toString())
        Log.e("Amount", Amount.toString())
        totalamountTxt.setText(Amount.toString())

    }

    fun getDetails() {
        ExpirydateTxt.setText(intent.getStringExtra("DTT_EXPIRY_DATE"))
        inceptionDateTxt.setText(intent.getStringExtra("DTT_INCEPTION_DATE"))
        issuedDateTxt.setText(intent.getStringExtra("DTT_ISSUE_DATE"))
        emailTxt.setText(intent.getStringExtra("EMAIL_ID"))
        mobilenumberTxt.setText(intent.getStringExtra("MOB_NUM"))
        numcoverageamtTxt.setText(intent.getStringExtra("NUM_EX_COVERAGE_AMT"))
        numberexcoveragepremiumTxt.setText(intent.getStringExtra("NUM_EX_COVERAGE_PREMIUM"))
        numberexcoveragetotTxt.setText(intent.getStringExtra("NUM_EX_COVERAGE_TOT"))
        numbermanufacturingyearTxt.setText(intent.getStringExtra("NUM_MANUFACTURE_YEAR"))
        numbermodelidTxt.setText(intent.getStringExtra("NUM_MODEL_ID"))
        numberservicetaxamountTxt.setText(intent.getStringExtra("NUM_SERVICE_TAX_AMOUNT"))
        numberservicetaxpercent.setText(intent.getStringExtra("NUM_SERVICE_TAX_ID"))
        numberservicetaxidTxt.setText(intent.getStringExtra("NUM_SERVICE_TAX_PERCENT"))
        vchchassisno.setText(intent.getStringExtra("VCH_CHASSIS_NO"))
        vchenginenumberTxt.setText(intent.getStringExtra("VCH_ENGINE_NO"))
        vchinsurednameTxt.setText(intent.getStringExtra("VCH_INSURED_NAME"))
        vchvehiclenumberTxt.setText(intent.getStringExtra("VCH_VEHICLE_NO"))
        vchinsuranceamountTxt.setText(intent.getStringExtra("VCH_INSURED_AMOUNT"))

    }
}
