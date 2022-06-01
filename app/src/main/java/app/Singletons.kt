package app

import android.content.Context
import app.model.SourcesProvider
import app.model.accounts.AccountRepository
import app.model.accounts.AccountSource
import app.model.ads.AdsRepository
import app.model.ads.AdsSource
import app.model.settings.AppSettings
import app.model.settings.SharedPreferencesAppSettings
import sources.SourceProviderHolder

object Singletons {

    private lateinit var appContext: Context

    private val sourcesProvider: SourcesProvider by lazy {
        SourceProviderHolder.sourcesProvider
    }


    val appSettings: AppSettings by lazy {
        SharedPreferencesAppSettings(appContext)
    }


    private val accountsSource: AccountSource by lazy {
        sourcesProvider.getAccountSource()
    }

    private val adsSource: AdsSource by lazy {
        sourcesProvider.getAdsSource()
    }

    //репозитории
    val accountsRepository: AccountRepository by lazy {
        AccountRepository(
            accountsSource = accountsSource
        )
    }

    val adsRepository: AdsRepository by lazy {
        AdsRepository(
            adsSource = adsSource
        )
    }

    fun init(appContext: Context) {
        Singletons.appContext = appContext
    }
}