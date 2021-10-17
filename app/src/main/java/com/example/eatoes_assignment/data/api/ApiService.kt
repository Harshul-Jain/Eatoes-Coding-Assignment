package com.example.eatoes_assignment.data.api

import com.example.eatoes_assignment.data.modals.LoginRequest
import com.example.eatoes_assignment.data.modals.LoginResponse
import com.example.eatoes_assignment.data.modals.LoginUnsuccessful
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @POST(Constants.LOGIN_URL)
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST(Constants.LOGIN_URL)
    suspend fun login(@Body email: String): Response<LoginUnsuccessful>
}
