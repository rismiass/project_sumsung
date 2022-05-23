package sources.base

import app.model.BackendException
import app.model.ConnectionException
import app.model.ParseBackendResponseException
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

open class BaseOkhttpSource(
    private val config: OkhttpConfig
) {
    val gson: Gson = config.gson
    private val contentType = "application/json; charset=utf-8".toMediaType()
    val client: OkHttpClient = config.client
    /**
    Здесь мы асинхронно запускаем запрос и выкидываем ошибки в соответствии с ситуацией
     */
    suspend fun Call.suspendEnqueue(): Response {
        return suspendCancellableCoroutine { continuation ->
            continuation.invokeOnCancellation {
                cancel()
            }
            enqueue(object : Callback {
                override fun onFailure(call: Call, e: okio.IOException) {
                    val appException = ConnectionException(e)
                    continuation.resumeWithException(appException)
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        continuation.resume(response)
                    } else {
                        handleErrorResponse(response, continuation)
                    }
                }
            })

        }
    }
    /**
    Эта функция объединяет стандартный url с путём на сервере
     */
    private fun handleErrorResponse(response: Response,
                                    continuation: CancellableContinuation<Response>) {
        val httpCode = response.code
        try {
            val map = gson.fromJson(response.body!!.string(), Map::class.java)
            val message = map["error"].toString()
            continuation.resumeWithException(BackendException(httpCode, message))
        } catch (e: Exception) {
            val appException = ParseBackendResponseException(e)
            continuation.resumeWithException(appException)
        }
    }

    fun Request.Builder.endpoint(endpoint: String): Request.Builder {
        url("${config.baseUrl}$endpoint")
        return this
    }
    /**
     *Конвертирует дата класс в json
     */
    fun <T> T.toJsonRequestBody(): RequestBody {
        val json = gson.toJson(this)
        return json.toRequestBody(contentType)
    }

    /**
     * Парсит json из ответа в словарь
     * @throws ParseBackendResponseException
     */
    fun <T> Response.parseJsonResponse(typeToken: TypeToken<T>): T {
        try {
            return gson.fromJson(this.body!!.string(), typeToken.type)
        } catch (e: Exception) {
            throw ParseBackendResponseException(e)
        }
    }


    /**
     * Парсит json из ответа в дата класс
     * @throws ParseBackendResponseException
     */
    inline fun <reified T> Response.parseJsonResponse(): T {
        try {
            return gson.fromJson(this.body!!.string(), T::class.java)
        } catch (e: Exception) {
            throw ParseBackendResponseException(e)
        }
    }

}