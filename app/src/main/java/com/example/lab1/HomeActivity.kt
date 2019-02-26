package com.example.lab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
import kz.iitu.activityexample.utils.PreferenceUtils

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initUI()
    }
    private fun initUI(){
            if (!PreferenceUtils.getLogged(this)) {
                startActivity(Intent(this, LoginActivity::class.java))
            } else {
                var email: String = PreferenceUtils.getCurrentEmail(this)
                name.text = PreferenceUtils.getName(this, email)
                age.text = PreferenceUtils.getAge(this, email).toString()
            }
        logoutBtn.setOnClickListener{
            PreferenceUtils.saveLogged(this, false)
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

}
