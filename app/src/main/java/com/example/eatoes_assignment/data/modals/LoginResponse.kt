package com.example.eatoes_assignment.data.modals

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    var token:String
)