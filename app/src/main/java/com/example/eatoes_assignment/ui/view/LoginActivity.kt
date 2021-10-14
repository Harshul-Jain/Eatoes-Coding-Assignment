package com.example.eatoes_assignment.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast
import com.example.eatoes_assignment.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSpannableString()
    }

    //Setting the SpannableString
    private fun setSpannableString() {
        val signUpText = SpannableString(getString(R.string.sign_up))
        val noAccountText = SpannableString(getString(R.string.no_eatoes_account))
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                //send back
                Toast.makeText(this@LoginActivity, "Sign Up First", Toast.LENGTH_SHORT).show()
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true
                ds.color = ds.linkColor
            }
        }
        signUpText.setSpan(clickableSpan, 0, signUpText.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        signUpTextView.movementMethod = LinkMovementMethod.getInstance()
        signUpTextView.text = signUpText
        noAccountText.setSpan(clickableSpan, 0, signUpText.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        noAccountTextView.movementMethod = LinkMovementMethod.getInstance()
        noAccountTextView.text = noAccountText
    }


}