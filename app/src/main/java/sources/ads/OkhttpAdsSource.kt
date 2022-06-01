package sources.ads

import app.model.ads.AdsSource
import app.model.ads.entities.Ad
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.delay
import okhttp3.Request
import sources.ads.entities.GetAdResponseEntity
import sources.base.BaseOkhttpSource
import sources.base.OkhttpConfig

class OkhttpAdsSource(
    config: OkhttpConfig
) : BaseOkhttpSource(config), AdsSource {
    override suspend fun getAds(): List<Ad> {
        delay(1000)
        val request = Request.Builder().get().endpoint("ads").build()
        val call = client.newCall(request)
        val typeToken = object : TypeToken<List<GetAdResponseEntity>>() {}
        val response = call.suspendEnqueue().parseJsonResponse(typeToken)
        return response.map { it.toAd() }

    }
}