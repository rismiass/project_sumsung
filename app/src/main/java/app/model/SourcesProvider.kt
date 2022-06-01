package app.model

import app.model.accounts.AccountSource
import app.model.ads.AdsSource

interface SourcesProvider {
    fun getAccountSource(): AccountSource
    fun getAdsSource(): AdsSource
}