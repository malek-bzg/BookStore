package com.example.examen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout


const val PREF_NAME = "LOGIN_PREF_CAR"
const val LOGIN = "LOGIN"
const val PASSWORD = "PASSWORD"
const val IS_REMEMBRED = "IS_REMEMBRED"

class LoginActivity : AppCompatActivity() {

    private lateinit var buttonLogin: Button
    private lateinit var username: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    lateinit var editTextuser1: TextInputLayout
    lateinit var editTextuser2: TextInputLayout
    private lateinit var remember_me: CheckBox
    lateinit var mSharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.title="Login";
        mSharedPref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        username = findViewById(R.id.username);
        email = findViewById(R.id.email)
        password = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.login);
        remember_me = findViewById(R.id.remember);
        editTextuser2 = findViewById(R.id.txtLayoutpassword)
        editTextuser1 = findViewById(R.id.txtLayoutLogin)


        if (mSharedPref.getBoolean(IS_REMEMBRED, false)){
            navigate()
        }

        buttonLogin.setOnClickListener {
            val user = username.text.toString();
            val pass = password.text.toString()
            val mail = email.text.toString()




            if (validate()!! && remember_me.isChecked()){
                mSharedPref.edit().apply{
                    putBoolean(IS_REMEMBRED, true)
                    putString(LOGIN, user)
                    putString(PASSWORD, pass)
                    putString(PASSWORD, mail)
                }.apply()
                navigate()
            }
            if (validate()!! && !remember_me.isChecked()){
                mSharedPref.edit().apply{
                    putBoolean(IS_REMEMBRED, false)
                    putString(LOGIN, user)
                    putString(PASSWORD, pass)
                    putString(PASSWORD, mail)
                }.apply()
                navigate()
            }

        }

    }

    private fun validate(): Boolean {
        editTextuser1.error = null
        editTextuser2.error = null

        if(username.text!!.isEmpty()){
            username.error="email required"
            username.requestFocus()
            return false
        }
        if(email.text!!.isEmpty()){
            email.error="email required"
            email.requestFocus()
            return false
        }

        if (password.text!!.isEmpty()) {
            editTextuser2.error = getString(R.string.mustNotBeEmpty)
            return false
        }

        return true
    }

    private fun navigate(){
        val mainIntent = Intent(this, homeActivity::class.java)
        startActivity(mainIntent)
    }
}