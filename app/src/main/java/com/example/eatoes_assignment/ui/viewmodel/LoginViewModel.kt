package com.example.eatoes_assignment.ui.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eatoes_assignment.data.repos.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {
    var result: String = ""
    var errorMessage: String = ""
    fun login(email: String, password: String) {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                LoginRepository.login(email, password)
            }
            if (response.code() == 200) {
                response.body()?.let {
                    result = it.token
                    Log.d("Hello", "${it.token}")
                }
            }
        }
    }

    fun login(email: String) {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                LoginRepository.login(email)
            }

            response.body()?.let {
                errorMessage = it.error
                Log.d("Hello", "${it.error}")
            }

        }
    }

    // Function for validating password
    fun validPassword(password: String): Boolean = LoginRepository.validPassword(password)

    // Function for validating EmailId
    fun validEmailId(emailId: String): Boolean = LoginRepository.validEmailId(emailId)
}