package sources.base

import app.model.SourcesProvider
import app.model.accounts.AccountSource
import app.model.ads.AdsSource
import sources.accounts.OkhttpAccountSource
import sources.ads.OkhttpAdsSource

class OkhttpSourcesProvider(
    private val config: OkhttpConfig
): SourcesProvider {
    override fun getAccountSource(): AccountSource {
        return OkhttpAccountSource(config)
    }

    override fun getAdsSource(): AdsSource {
        return OkhttpAdsSource(config)
    }
}