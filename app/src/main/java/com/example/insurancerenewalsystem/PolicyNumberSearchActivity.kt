package com.example.insurancerenewalsystem

import android.Manifest
import android.arch.persistence.room.Room
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.ActivityCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.*
import android.telephony.SmsManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import com.example.insurancerenewalsystem.Adapter.PolicyAdapter
import com.example.insurancerenewalsystem.Adapter.RecyclerviewAdapter
import com.example.insurancerenewalsystem.Database.AppDatabase
import com.example.insurancerenewalsystem.Database.Dao.PolicyNumberTableDao
import com.example.insurancerenewalsystem.Database.Table.PolicyNumberTable
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_policy_number_search.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList


class PolicyNumberSearchActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var toolbar: Toolbar
    lateinit var swiperefreshlayout: SwipeRefreshLayout
    lateinit var recyclerview: RecyclerView
    lateinit var databasereference: DatabaseReference
    var list: ArrayList<InsurancenumberModelclass>? = null
    lateinit var beetleList: MutableList<InsurancenumberModelclass>
    lateinit var firebaseDatabase: FirebaseDatabase
    var strDate: String = ""
    private var PolicyNumberTableDao: PolicyNumberTableDao? = null
    lateinit var policynumberEdt: AppCompatEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_policy_number_search)

        firebaseDatabase = FirebaseDatabase.getInstance()
        databasereference = firebaseDatabase.getReference("POLICY NUMBER")
        list = ArrayList<InsurancenumberModelclass>()

        toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.setTitleTextColor(resources.getColor(R.color.appcolor))

        setSupportActionBar(toolbar)
        recyclerview = findViewById(R.id.recyclerview) as RecyclerView
        swiperefreshlayout = findViewById(R.id.swiperefreshlayout) as SwipeRefreshLayout
        swiperefreshlayout.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            Handler().postDelayed(Runnable { swiperefreshlayout.setRefreshing(false) }, 3000)
        })

        // recyclerview.layoutManager = LinearLayoutManager(this@PolicyNumberSearchActivity, LinearLayout.VERTICAL, false)

        policynumberEdt = findViewById(R.id.policynumberEdt) as AppCompatEditText

        searchBtn.setOnClickListener {
            val search = PolicyNumberTableDao?.PolicynumberSearch(policynumberEdt.text.toString())
            if (search?.size == 0) {
                ShowToast("Your searched policy number not found")
            } else {
                val empidrequest =
                    RecyclerviewAdapter(
                        search as ArrayList<PolicyNumberTable>,
                        this@PolicyNumberSearchActivity
                    )
                recyclerview.layoutManager =
                    LinearLayoutManager(this@PolicyNumberSearchActivity, LinearLayout.VERTICAL, false)
                recyclerview.setItemAnimator(DefaultItemAnimator())
                recyclerview.setHasFixedSize(true)
                recyclerview.adapter = empidrequest
            }
        }

        getdataFirebase()
        Dbconnection()
        val c = Calendar.getInstance()
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        strDate = sdf.format(c.time)

        val search = PolicyNumberTableDao?.getAll()
        Log.e("search", search?.size.toString())



    }

    fun ShowToast(s: String) {
        Toast.makeText(this@PolicyNumberSearchActivity, s, Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {

            R.id.menu_sign_out -> {

                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    fun getdataFirebase() {

        databasereference = firebaseDatabase.getReference("POLICY NUMBER")
        databasereference.addChildEventListener(object : ChildEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildAdded(dataSnapshot: DataSnapshot, p1: String?) {

                recyclerview.setItemAnimator(DefaultItemAnimator())
                recyclerview.setHasFixedSize(true)

                firebaseDatabase = FirebaseDatabase.getInstance()
                databasereference = firebaseDatabase.getReference("POLICY NUMBER")

                var InsurancenumberModelclass = InsurancenumberModelclass()
                InsurancenumberModelclass = dataSnapshot.getValue(InsurancenumberModelclass::class.java)!!
                Log.e("DTT_ISSUED_DATE",InsurancenumberModelclass.DTT_ISSUE_DATE)
                list!!.add(InsurancenumberModelclass)

                val empidrequest =
                    PolicyAdapter(
                        list as ArrayList<InsurancenumberModelclass>,
                        this@PolicyNumberSearchActivity
                    )
                recyclerview.layoutManager =
                    LinearLayoutManager(this@PolicyNumberSearchActivity, LinearLayout.VERTICAL, false)
                recyclerview.setItemAnimator(DefaultItemAnimator())
                recyclerview.setHasFixedSize(true)
                recyclerview.adapter = empidrequest


                policynumberEdt.addTextChangedListener(object:TextWatcher
                {
                    override fun afterTextChanged(s: Editable?) {
                        if(policynumberEdt.text.toString().length==0)
                        {
                            val empidrequest =
                                PolicyAdapter(
                                    list as ArrayList<InsurancenumberModelclass>,
                                    this@PolicyNumberSearchActivity
                                )
                            recyclerview.layoutManager =
                                LinearLayoutManager(this@PolicyNumberSearchActivity, LinearLayout.VERTICAL, false)
                            recyclerview.setItemAnimator(DefaultItemAnimator())
                            recyclerview.setHasFixedSize(true)
                            recyclerview.adapter = empidrequest
                        }
                    }

                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                        if(policynumberEdt.text.toString().length==0)
                        {
                            val empidrequest =
                                PolicyAdapter(
                                    list as ArrayList<InsurancenumberModelclass>,
                                    this@PolicyNumberSearchActivity
                                )
                            recyclerview.layoutManager =
                                LinearLayoutManager(this@PolicyNumberSearchActivity, LinearLayout.VERTICAL, false)
                            recyclerview.setItemAnimator(DefaultItemAnimator())
                            recyclerview.setHasFixedSize(true)
                            recyclerview.adapter = empidrequest
                        }
                    }

                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                        if(policynumberEdt.text.toString().length==0)
                        {
                            val empidrequest =
                                PolicyAdapter(
                                    list as ArrayList<InsurancenumberModelclass>,
                                    this@PolicyNumberSearchActivity
                                )
                            recyclerview.layoutManager =
                                LinearLayoutManager(this@PolicyNumberSearchActivity, LinearLayout.VERTICAL, false)
                            recyclerview.setItemAnimator(DefaultItemAnimator())
                            recyclerview.setHasFixedSize(true)
                            recyclerview.adapter = empidrequest
                        }
                    }

                })

                val PolicyNumberTable = PolicyNumberTable()

                val policynumbersearch =
                    PolicyNumberTableDao?.PolicynumberSearch(InsurancenumberModelclass.VCH_POLICY_NO)

                if (policynumbersearch?.size == 0) {
                    PolicyNumberTable.DTT_EXPIRY_DATE = InsurancenumberModelclass.DTT_EXPIRY_DATE
                    PolicyNumberTable.DTT_INCEPTION_DATE = InsurancenumberModelclass.DTT_INCEPTION_DATE
                    PolicyNumberTable.DTT_ISSUE_DATE = InsurancenumberModelclass.DTT_ISSUE_DATE
                    PolicyNumberTable.EMAIL_ID = InsurancenumberModelclass.EMAIL_ID
                    PolicyNumberTable.MOB_NUM = InsurancenumberModelclass.MOB_NUM
                    PolicyNumberTable.NUM_EX_COVERAGE_AMT = InsurancenumberModelclass.NUM_EX_COVERAGE_AMT
                    PolicyNumberTable.NUM_EX_COVERAGE_PREMIUM = InsurancenumberModelclass.NUM_EX_COVERAGE_PREMIUM
                    PolicyNumberTable.NUM_EX_COVERAGE_TOT = InsurancenumberModelclass.NUM_EX_COVERAGE_TOT
                    PolicyNumberTable.NUM_MANUFACTURE_YEAR = InsurancenumberModelclass.NUM_MANUFACTURE_YEAR
                    PolicyNumberTable.NUM_MODEL_ID = InsurancenumberModelclass.NUM_MODEL_ID
                    PolicyNumberTable.NUM_SERVICE_TAX_AMOUNT = InsurancenumberModelclass.NUM_SERVICE_TAX_AMOUNT
                    PolicyNumberTable.NUM_SERVICE_TAX_ID = InsurancenumberModelclass.NUM_SERVICE_TAX_ID
                    PolicyNumberTable.NUM_SERVICE_TAX_PERCENT = InsurancenumberModelclass.NUM_SERVICE_TAX_PERCENT
                    PolicyNumberTable.VCH_CHASSIS_NO = InsurancenumberModelclass.VCH_CHASSIS_NO
                    PolicyNumberTable.VCH_ENGINE_NO = InsurancenumberModelclass.VCH_ENGINE_NO
                    PolicyNumberTable.VCH_INSURED_NAME = InsurancenumberModelclass.VCH_INSURED_NAME
                    PolicyNumberTable.VCH_VEHICLE_NO = InsurancenumberModelclass.VCH_VEHICLE_NO
                    PolicyNumberTable.VCH_POLICY_NO = InsurancenumberModelclass.VCH_POLICY_NO
                    PolicyNumberTable.VCH_INSURED_AMOUNT = InsurancenumberModelclass.VCH_INSURED_AMOUNT
                    PolicyNumberTableDao?.insert(PolicyNumberTable)

                }


                val format = SimpleDateFormat("dd/MM/yyyy")
                val date1: Date = format.parse(strDate)
                val date2: Date = format.parse(InsurancenumberModelclass.DTT_EXPIRY_DATE)
                val diff = date2.time - date1.time
                var Noofdays: Long = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1
                Log.e("date difference", Noofdays.toString())
                var days: String = Noofdays.toString()

                if (days.equals("30")) {
                    Log.e("days", days)
                    if (ActivityCompat.checkSelfPermission(
                            this@PolicyNumberSearchActivity,
                            Manifest.permission.SEND_SMS
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {

                        ActivityCompat.requestPermissions(
                            this@PolicyNumberSearchActivity,
                            arrayOf(Manifest.permission.SEND_SMS),
                            123
                        )
                    } else {
                        val smsManager = SmsManager.getDefault()
                        smsManager.sendTextMessage(
                            InsurancenumberModelclass.MOB_NUM,
                            null,
                            "Greetings from ADG INSURANCE COMPANY. This message is to notify you that about the end of the renewel period of your policy.  Please ensure that you would renew it before the last date of " + InsurancenumberModelclass.DTT_EXPIRY_DATE + " and your ref policy number : " + InsurancenumberModelclass.VCH_POLICY_NO,
                            null,
                            null
                        )
                        Toast.makeText(
                            applicationContext, "SMS sent.",
                            Toast.LENGTH_LONG
                        ).show()

                        val TO = arrayOf(InsurancenumberModelclass.EMAIL_ID)
                        val intent = Intent(Intent.ACTION_SEND)
                        intent.data = Uri.parse("mailto:")
                        intent.type = "text/html"
                        intent.putExtra(Intent.EXTRA_EMAIL, TO)
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Insurance renewal - reg.")
                        intent.putExtra(
                            Intent.EXTRA_TEXT,
                            "Greetings from ADG INSURANCE COMPANY. This message is to notify you that about the end of the renewel period of your policy.  Please ensure that you would renew it before the last date of " + InsurancenumberModelclass.DTT_EXPIRY_DATE + " and your ref policy number : " + InsurancenumberModelclass.VCH_POLICY_NO
                        )
                        startActivity(Intent.createChooser(intent, "Send Email"))

                    }
                }

            }

            override fun onChildRemoved(p0: DataSnapshot) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

    }

    fun Dbconnection() {
        var db: AppDatabase? = null
        db = Room.databaseBuilder(
            this@PolicyNumberSearchActivity,
            AppDatabase::class.java, "pocroom_database"
        ).allowMainThreadQueries().build()
        PolicyNumberTableDao = db.PolicyNumberTableDao()
    }

}
