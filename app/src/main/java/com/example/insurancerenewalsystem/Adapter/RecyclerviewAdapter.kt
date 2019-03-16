package com.example.insurancerenewalsystem.Adapter

import android.content.Intent
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.insurancerenewalsystem.Database.Table.PolicyNumberTable
import com.example.insurancerenewalsystem.PolicyCustomersDetailsActivity
import com.example.insurancerenewalsystem.PolicyNumberSearchActivity
import com.example.insurancerenewalsystem.R
import java.util.*

class RecyclerviewAdapter(
    val arrayList: ArrayList<PolicyNumberTable>,
    val context: PolicyNumberSearchActivity
) : RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder>() {

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameTxt.setText(arrayList.get(position).VCH_INSURED_NAME)
        holder.policynoTxt.setText(arrayList.get(position).VCH_POLICY_NO)

        holder.nameTxt.setOnClickListener {

            val intent = Intent(context, PolicyCustomersDetailsActivity::class.java)
            intent.putExtra("DTT_EXPIRY_DATE", arrayList.get(position).DTT_EXPIRY_DATE)
            intent.putExtra("DTT_INCEPTION_DATE", arrayList.get(position).DTT_INCEPTION_DATE)
            intent.putExtra("DTT_ISSUE_DATE", arrayList.get(position).DTT_ISSUE_DATE)
            intent.putExtra("EMAIL_ID", arrayList.get(position).EMAIL_ID)
            intent.putExtra("MOB_NUM", arrayList.get(position).MOB_NUM)
            intent.putExtra("NUM_EX_COVERAGE_AMT", arrayList.get(position).NUM_EX_COVERAGE_AMT)
            intent.putExtra("NUM_EX_COVERAGE_PREMIUM", arrayList.get(position).NUM_EX_COVERAGE_PREMIUM)
            intent.putExtra("NUM_EX_COVERAGE_TOT", arrayList.get(position).NUM_EX_COVERAGE_TOT)
            intent.putExtra("NUM_MANUFACTURE_YEAR", arrayList.get(position).NUM_MANUFACTURE_YEAR)
            intent.putExtra("NUM_MODEL_ID", arrayList.get(position).NUM_MODEL_ID)
            intent.putExtra("NUM_SERVICE_TAX_AMOUNT", arrayList.get(position).NUM_SERVICE_TAX_AMOUNT)
            intent.putExtra("NUM_SERVICE_TAX_ID", arrayList.get(position).NUM_SERVICE_TAX_ID)
            intent.putExtra("NUM_SERVICE_TAX_PERCENT", arrayList.get(position).NUM_SERVICE_TAX_PERCENT)
            intent.putExtra("VCH_CHASSIS_NO", arrayList.get(position).VCH_CHASSIS_NO)
            intent.putExtra("VCH_ENGINE_NO", arrayList.get(position).VCH_ENGINE_NO)
            intent.putExtra("VCH_INSURED_NAME", arrayList.get(position).VCH_INSURED_NAME)
            intent.putExtra("VCH_VEHICLE_NO", arrayList.get(position).VCH_VEHICLE_NO)
            intent.putExtra("VCH_POLICY_NO", arrayList.get(position).VCH_POLICY_NO)
            intent.putExtra("VCH_INSURED_AMOUNT", arrayList.get(position).VCH_INSURED_AMOUNT)

            context?.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_items, parent, false)

        return MyViewHolder(v)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTxt = view.findViewById(R.id.nameTxt) as AppCompatTextView
        val policynoTxt = view.findViewById(R.id.policynoTxt) as AppCompatTextView
    }
}