package com.example.insurancerenewalsystem

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatEditText
import android.support.v7.widget.AppCompatTextView
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    private var mProgressBar: ProgressDialog? = null
    lateinit var emailidEdt: AppCompatEditText
    lateinit var passwordEdt: AppCompatEditText
    lateinit var loginBtn: AppCompatTextView

    private var email: String? = null
    private var password: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailidEdt = findViewById(R.id.emailidEdt) as AppCompatEditText
        passwordEdt = findViewById(R.id.passwordEdt) as AppCompatEditText
        loginBtn = findViewById(R.id.loginBtn) as AppCompatTextView

        mProgressBar = ProgressDialog(this)

       /* loginBtn!!.setOnClickListener { loginUser() }
*/

        loginBtn!!.setOnClickListener {

            val email = emailidEdt.text.toString()
            val password = passwordEdt.text.toString()

            if(email.isEmpty() || password.isEmpty())  {
                Toast.makeText(this,"Enter Email or password",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
            val auth = FirebaseAuth.getInstance()
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                if (!it.isSuccessful) return@addOnCompleteListener

                Toast.makeText(this,"LOGGED IN SUCCESSFULLY",Toast.LENGTH_SHORT).show()
                val intent = Intent(this,PolicyNumberSearchActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)

            }
                .addOnFailureListener {
                    Toast.makeText(this,"INCORRECT EMAIL/PASSWORD",Toast.LENGTH_SHORT).show()
                }

        }






    }

    fun ShowToast(s: String) {
        Toast.makeText(applicationContext, s, Toast.LENGTH_SHORT).show()
    }

   /* private fun loginUser() {
        FirebaseApp.initializeApp(this)
        email = emailidEdt?.text.toString()
        password = passwordEdt?.text.toString()
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            mProgressBar!!.setMessage("Registering User...")
            mProgressBar!!.show()

            mAuth!!.signInWithEmailAndPassword(email!!, password!!)
                .addOnCompleteListener(this) { task ->
                    mProgressBar!!.hide()
                    if (task.isSuccessful) {
                        // Sign in success, update UI with signed-in user's information

                        updateUI()
                    } else {
                        // If sign in fails, display a message to the user.
                        ShowToast("Authentication failed")
                    }
                }
        } else {
            ShowToast("Enter all details")
        }
    }
*/
    private fun updateUI() {
        val intent = Intent(this@LoginActivity, PolicyNumberSearchActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }


}





