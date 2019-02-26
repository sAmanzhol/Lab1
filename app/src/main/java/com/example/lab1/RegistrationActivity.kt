package com.example.lab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*
import kz.iitu.activityexample.utils.PreferenceUtils

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        initUI()
    }

    private fun initUI(){
        regLoginBtn.setOnClickListener {
            if (PreferenceUtils.getEmail(this, regEmail.text.toString()).equals(regEmail.text.toString())) {
                Toast.makeText(this, "Email already exist", Toast.LENGTH_LONG).show()
            } else {
                PreferenceUtils.saveEmail(this, regEmail.text.toString())
                PreferenceUtils.saveName(this, regEmail.text.toString(), regName.text.toString())
                PreferenceUtils.savePassword(this, regEmail.text.toString(), regPass.text.toString())
                PreferenceUtils.saveAge(this, regEmail.text.toString(), Integer.parseInt(regAge.text.toString()))
                startActivity(Intent(this, LoginActivity::class.java))
            }

        }

        regBackBtn.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }


    }
}
