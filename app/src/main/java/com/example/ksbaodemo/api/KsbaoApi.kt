package com.example.ksbaodemo.api

import com.example.ksbaodemo.data.KsbClass
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface KsbaoApi {

    companion object {
        private val BASE_URL = "https://slb-activity.ksbao.com"
        fun createApi(): KsbaoApi {
            val json = Json {
                ignoreUnknownKeys = true
                isLenient = true
            }
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpClient())
                .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
                .build()
                .create(KsbaoApi::class.java)
        }
    }

    @GET("/api/research/getKsbClass")
    suspend fun getKsbClass(
        @Query("isHot") isHot: Int = 0
    ): KsbClass
}