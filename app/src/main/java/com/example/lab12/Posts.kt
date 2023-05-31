package com.example.lab12
import com.google.gson.annotations.SerializedName

data class Posts(
    @SerializedName("userId")
    val user: Int ,
    @SerializedName("id")
    val Id : Int ,
    @SerializedName("title")
    val title :String,
    @SerializedName ("body")
    val subtitle: String
)
