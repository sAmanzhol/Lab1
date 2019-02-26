package com.example.lab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kz.iitu.activityexample.utils.PreferenceUtils

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initUI()
    }

    private fun initUI() {
        loginBtn.setOnClickListener {
            if (PreferenceUtils.getEmail(this, inputLogin.text.toString()).equals(inputLogin.text.toString()) &&
                PreferenceUtils.getPassword(this, inputLogin.text.toString()).equals(inputPass.text.toString())
            ) {
                PreferenceUtils.saveLogged(this, true)
                PreferenceUtils.saveCurrentEmail(this, inputLogin.text.toString())
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                Toast.makeText(this, "Invalid data", Toast.LENGTH_LONG).show()
            }
        }
        signUpBtn.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
    }

    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}
