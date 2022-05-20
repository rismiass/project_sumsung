package app

import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor


data class Users(
    val users: List<String>,
    val status: String
)

val contentType = "application/json; charset=utf-8".toMediaType()
fun main(){
    val loggingInterceptor  = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    val gson = Gson()
    val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor).build()

    val request = Request.Builder()
        .get().url("http://127.0.0.1:5000/").build()

    val call  = client.newCall(request)
    val response = call.execute()
    val responseBodyString = response.body!!.string()
    val res = gson.fromJson<Users>(responseBodyString, Users::class.java)
    print(res.users)




}