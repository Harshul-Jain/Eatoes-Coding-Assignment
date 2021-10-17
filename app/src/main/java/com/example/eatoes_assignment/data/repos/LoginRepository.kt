package com.example.eatoes_assignment.data.repos

import com.example.eatoes_assignment.data.api.Client
import com.example.eatoes_assignment.data.modals.LoginRequest

object LoginRepository {


    private val emailPattern = Regex(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    suspend fun login(email: String, password: String) =
        Client.api.login(LoginRequest(email, password))

    suspend fun login(email: String) = Client.api.login(email)

    fun validPassword(password: String): Boolean {
        return password.isNotEmpty()
    }

    fun validEmailId(emailId: String): Boolean {
        if (emailId != null) {
            return emailPattern.matches(emailId)
        }
        return false
    }
}