package com.example.team_voida.Categories

import com.example.team_voida.Home.Popular
import kotlinx.serialization.json.Json
import java.net.HttpURLConnection
import java.net.URL

suspend fun CategoryServer(
    categoryCode: String
):List<Popular>?{
    try{
        val url = URL(" https://fluent-marmoset-immensely.ngrok-free.app/CategoriesItems/${categoryCode}") // edit1
        val connection = url.openConnection() as java.net.HttpURLConnection
        connection.requestMethod = "GET" // edit2 // or POST

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