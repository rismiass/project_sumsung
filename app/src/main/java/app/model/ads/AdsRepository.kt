package app.model.ads

import app.model.BackendException
import app.model.EmptyFieldException
import app.model.Field
import app.model.InvalidCredentialsException
import app.model.ads.entities.Ad

class AdsRepository(
    private val adsSource: AdsSource
) {
    suspend fun getAds(): List<Ad> {
        val lstAds = try {
            adsSource.getAds()
        } catch (e: Exception) {
            if (e is BackendException && e.code == 401) {
                // map 401 error for sign-in to InvalidCredentialsException
                throw InvalidCredentialsException(e)
            } else {
                throw e
            }

        }
        return lstAds
        // success! got auth token -> save it
        // and load account data
        //accountLazyFlowSubject.updateAllValues(accountsSource.getAccount())
    }
}