package app

import com.google.gson.Gson
import com.squareup.moshi.Moshi
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import sources.accounts.AccountApi
import sources.accounts.entities.SignInRequestEntity
import sources.accounts.entities.SignInResponseEntity


val contentType = "application/json; charset=utf-8".toMediaType()
fun main(){
    val loggingInterceptor  = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val gson = Gson()
    val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor)
        .build()

    val requestBody = SignInRequestEntity(
        email = "rismiass@yandex.ru",
        password = "8888"
    )
    val requestBodyString = gson.toJson(requestBody)
    val okHttpRequestBody = requestBodyString.toRequestBody(contentType)

    val request = Request.Builder().
            post(okHttpRequestBody).
            url("http://127.0.0.1:5000/sign-in").build()

    val call = client.newCall(request)
    val response = call.execute()
    if (response.isSuccessful) {
        val responseBodyString = response.body!!.string()
        val signInResponseBody = gson.fromJson(responseBodyString, SignInResponseEntity::class.java)
        print(signInResponseBody.token)
    }


}