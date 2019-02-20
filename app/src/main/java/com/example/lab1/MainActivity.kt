package com.example.lab1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        addBtn.setOnClickListener {
            result.text = (inputFirst.text.toString().toInt()
                            + inputSecond.text.toString().toInt()).toString()
        }
        difBtn.setOnClickListener {
            result.text = (inputFirst.text.toString().toInt()
                            - inputSecond.text.toString().toInt()).toString()
        }
        mulBtn.setOnClickListener {
            result.text = (inputFirst.text.toString().toInt()
                            * inputSecond.text.toString().toInt()).toString()
        }
        divBtn.setOnClickListener {
            if (inputSecond.text.toString().toInt() == 0) {
                Toast.makeText(this, getString(R.string.zero_division_error), Toast.LENGTH_LONG).show()

            } else {
                result.text = (inputFirst.text.toString().toInt()
                                / inputSecond.text.toString().toInt()).toString()
            }
        }
        clearBtn.setOnClickListener {
            inputFirst.text = null
            inputSecond.text = null
            result.text = null
        }
    }
}

