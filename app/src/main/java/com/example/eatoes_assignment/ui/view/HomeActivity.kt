package com.example.eatoes_assignment.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eatoes_assignment.R
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email = intent.getStringExtra("EMAIL_ID")
        val token = intent.getStringExtra("TOKEN")
        homeTextView.text="Hello \n $email \n Your token is \n $token"
    }
}