package com.example.insurancerenewalsystem

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.google.firebase.database.*
import java.util.ArrayList

class RecyclerviewTest : AppCompatActivity() {

    lateinit var recyclerview: RecyclerView
    lateinit var databasereference: DatabaseReference
    var list: ArrayList<InsurancenumberModelclass>? = null
    lateinit var firebaseDatabase: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview_test)

        firebaseDatabase = FirebaseDatabase.getInstance()
        databasereference = firebaseDatabase.getReference("POLICY NUMBER")
        list = ArrayList<InsurancenumberModelclass>()

        recyclerview = findViewById(R.id.recyclerview) as RecyclerView

        databasereference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                list = ArrayList<InsurancenumberModelclass>()
                val child = dataSnapshot!!.children
                var InsurancenumberModelclass = InsurancenumberModelclass()
                InsurancenumberModelclass = dataSnapshot.getValue(InsurancenumberModelclass::class.java)!!
                list!!.add(InsurancenumberModelclass)
/*
                val empidrequest =
                    RecyclerviewAdapter(
                        list as ArrayList<InsurancenumberModelclass>,
                        this@RecyclerviewTest
                    )
                recyclerview.layoutManager =
                    LinearLayoutManager(this@RecyclerviewTest, LinearLayout.VERTICAL, false)
                recyclerview.setItemAnimator(DefaultItemAnimator())
                recyclerview.adapter = empidrequest*/


            }

        })

    }
}
