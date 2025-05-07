package com.example.team_voida.Home

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import java.net.HttpURLConnection
import java.net.URL

suspend fun HomePopularCall():List<Popular>?{
    try{
        val url = URL(" https://fluent-marmoset-immensely.ngrok-free.app") // edit1
        val connection = url.openConnection() as java.net.HttpURLConnection
        connection.requestMethod = "POST" // edit2

        if(connection.responseCode == HttpURLConnection.HTTP_OK){
            val inputStream = connection.inputStream.bufferedReader().use{it.readText()}
            val json = Json.decodeFromString<List<Popular>>(inputStream) // edit3
            return json
        } else {
            return null
        }
    } catch (e:Exception){
        e.printStackTrace()
        return null
    }
}