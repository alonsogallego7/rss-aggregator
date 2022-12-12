package com.alonsogallego.rss_aggregator.app.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class ApiClient {

    private val apiServices: ApiServices

    init {
        apiServices = buildApiEndPoints()
    }

    fun createRetrofitClient() = Retrofit.Builder()
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .baseUrl("https://google.es/")
        .build()

    fun buildApiEndPoints() = createRetrofitClient().create(ApiServices::class.java)

    suspend fun getRss(url: String): RssApiModel {
        return apiServices.getRss(url).body()!!
    }
}