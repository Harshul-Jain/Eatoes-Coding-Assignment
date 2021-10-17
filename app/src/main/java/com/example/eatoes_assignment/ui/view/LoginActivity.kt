package com.example.eatoes_assignment.ui.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.eatoes_assignment.R
import com.example.eatoes_assignment.ui.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSpannableString()
        //setOnClickListener on login Button
        loginBtn.setOnClickListener {
            val emailId = emailEdt.text.toString()
            val password = passwordEdt.text.toString()
            val validEmailId = viewModel.validEmailId(emailId)
            if (!validEmailId) {
                emailEdt.error = "Enter correct Email ID"
            }
            val validPassword = viewModel.validPassword(password)
            if (!validPassword) {
                passwordEdt.error = "Enter correct Password "
            }
            if (validEmailId && validPassword) {
                viewModel.login(emailId, password)
                if (viewModel.result.isNotEmpty()) {
                    val intent = Intent(this, HomeActivity::class.java)
                        .putExtra(
                            "EMAIL_ID",
                            emailEdt.text.toString()
                        )
                        .putExtra("TOKEN", viewModel.result)
                    startActivity(intent)
                } else {
                    viewModel.login(emailId)
                    if (viewModel.errorMessage.isNotEmpty()) {
                        Toast.makeText(this, viewModel.errorMessage, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    //Setting the SpannableString
    private fun setSpannableString() {
        val signUpText = SpannableString(getString(R.string.sign_up))
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                //send back
                Toast.makeText(this@LoginActivity, "Sign Up First", Toast.LENGTH_SHORT).show()
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true
                ds.color = Color.parseColor("#fe7469")
            }
        }
        signUpText.setSpan(clickableSpan, 0, signUpText.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        signUpTextView.movementMethod = LinkMovementMethod.getInstance()
        signUpTextView.text = signUpText
    }


}