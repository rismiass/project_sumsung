package sources

import app.Const
import app.model.SourcesProvider
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import sources.base.RetrofitConfig
import sources.base.RetrofitSourcesProvider

object RetrofitProviderHolder {
    val sourcesProvider: SourcesProvider by lazy<SourcesProvider> {
        val moshi = Moshi.Builder().build()
        val config = RetrofitConfig(
            retrofit = createRetrofit(moshi),
            moshi = moshi
        )
        RetrofitSourcesProvider(config)
    }

    private fun createRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder().baseUrl(Const.BASE_URL).client(createOkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
    }

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(createLoggingInterceptor())
            .build()
    }

    private fun createLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

}