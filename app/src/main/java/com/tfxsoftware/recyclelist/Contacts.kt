package com.tfxsoftware.recyclelist

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.Serializable
import okhttp3.OkHttpClient
import okhttp3.Request
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.*


class Contacts() {
    var list: List<ContactEntry> = listOf()
    var string: String = ""
    init {
        fetchData()
    }


    fun fetchData() {
        GlobalScope.launch(Dispatchers.Main) {
            val gson = Gson()
            string = "[{\"name\":\"tomas\",\"number\":\"19983132324\"},{\"number\":\"1968463\",\"name\":\"wesley\"}]"
            list = gson.fromJson(string, Array<ContactEntry>::class.java).asList()

        }
    }


    private suspend fun makeNetworkRequest(url: String): String = withContext(Dispatchers.IO) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()
        val response = client.newCall(request).execute()
        return@withContext response.body?.string() ?: "contato"
    }
}
