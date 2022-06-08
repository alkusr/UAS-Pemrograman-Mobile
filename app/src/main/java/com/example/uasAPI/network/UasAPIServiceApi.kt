package com.example.uasAPI.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val BASE_URL = "https://indonesia-public-static-api.vercel.app/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface UasAPIServiceApi {
    @GET("heroes")
    suspend fun getPahlawan(): List<Pahlawan>

    @GET("volcanoes")
    suspend fun getGunung(): List<Gunung>

    @GET("publishers")
    suspend fun getPenerbit(): List<Penerbit>
}

object UasAPIApi {
    val retrofitServiceApi: UasAPIServiceApi by lazy {
        retrofit.create(UasAPIServiceApi::class.java)
    }
}