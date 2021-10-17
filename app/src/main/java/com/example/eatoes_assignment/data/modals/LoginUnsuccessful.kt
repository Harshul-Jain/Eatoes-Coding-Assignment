package com.example.eatoes_assignment.data.modals

import com.google.gson.annotations.SerializedName

data class LoginUnsuccessful(
    @SerializedName("error")
    var error:String = ""
)