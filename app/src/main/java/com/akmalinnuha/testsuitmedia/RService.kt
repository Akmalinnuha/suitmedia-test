package com.akmalinnuha.testsuitmedia

import retrofit2.Call
import retrofit2.http.GET

interface RService {
    @GET("users")
    fun getStudents(): Call<item_data>
}