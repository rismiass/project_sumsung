package sources.base

import com.google.gson.Gson
import okhttp3.OkHttpClient

/*
Здесь находится всё необходимое для совершение запросов
 */
class OkhttpConfig (
    val baseUrl: String,
    val client: OkHttpClient,
    val gson: Gson
)
