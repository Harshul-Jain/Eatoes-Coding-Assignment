package com.example.eatoes_assignment.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eatoes_assignment.data.repos.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {
    var result: String = ""
    var error: String = ""
    fun login(email: String, password: String) {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                LoginRepository.login(email, password)
            }
            if (response.code() == 200) {
                response.body()?.let {
                    result = it.token
                }
            } else if (response.code() == 400) {
                // Return error message
            }
        }
    }
}