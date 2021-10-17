package com.example.eatoes_assignment.data.repos

import com.example.eatoes_assignment.data.api.Client
import com.example.eatoes_assignment.data.modals.LoginRequest

object LoginRepository {

    suspend fun login(email: String, password: String) =
        Client.api.login(LoginRequest(email, password))

    suspend fun login(email: String) = Client.api.login(email)
}