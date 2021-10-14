package com.example.eatoes_assignment.data.modals

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("email")
    var email:String,
    @SerializedName("password")
    var password:String
)