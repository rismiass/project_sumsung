package app.model.ads

import app.model.ads.entities.Ad

interface AdsSource {

    suspend fun getAds(): List<Ad>
}