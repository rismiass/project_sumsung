package sources

import app.Const
import app.Singletons
import app.model.SourcesProvider
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import sources.base.OkhttpConfig
import sources.base.OkhttpSourcesProvider

object SourceProviderHolder {
    val sourcesProvider: SourcesProvider by lazy<SourcesProvider> {
        val config = OkhttpConfig(
            baseUrl = Const.BASE_URL,
            client = createOkHttpClient(),
            gson = Gson()
        )
        OkhttpSourcesProvider(config)
    }

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(createLoggingInterceptor()).build()
    }

    private fun createAuthorizationInterceptor() {

    }

    private fun createLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

}