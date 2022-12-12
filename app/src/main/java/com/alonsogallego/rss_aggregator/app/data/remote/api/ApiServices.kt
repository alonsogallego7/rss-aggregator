package com.alonsogallego.rss_aggregator.app.data.remote.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiServices {
    @GET
    suspend fun getRss(@Url url: String): Response<RssApiModel>
}