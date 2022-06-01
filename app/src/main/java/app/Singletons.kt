package app

import android.content.Context
import app.model.SourcesProvider
import app.model.accounts.AccountRepository
import app.model.accounts.AccountSource
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

    //репозитории
    val accountsRepository: AccountRepository by lazy {
        AccountRepository(
            accountsSource = accountsSource
        )
    }

    fun init(appContext: Context) {
        Singletons.appContext = appContext
    }
}