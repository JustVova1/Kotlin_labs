package com.example.lab12

import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val modifiedRequest = request.newBuilder()
            .addHeader("Authorization", "Bearer YOUR_TOKEN")
            .addHeader("Content-Type", "application/json")
            .build()
        return chain.proceed(modifiedRequest)
    }
}
