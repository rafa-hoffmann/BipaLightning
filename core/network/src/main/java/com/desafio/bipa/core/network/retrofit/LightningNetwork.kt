package com.desafio.bipa.core.network.retrofit

import com.desafio.bipa.core.network.RemoteDataSource
import com.desafio.bipa.core.network.model.NetworkNode
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.http.GET

internal interface LightningApi {

    @GET("v1/lightning/nodes/rankings/connectivity")
    suspend fun getNodes(): List<NetworkNode>
}

internal class LightningNetwork(
    networkJson: Json
) : RemoteDataSource {

    private val networkApi = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
        .build().create(LightningApi::class.java)

    companion object {
        private const val BASE_URL = "https://mempool.space/api/"
    }

    override suspend fun getNodes(): List<NetworkNode> = networkApi.getNodes()
}