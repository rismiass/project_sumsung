package app

import android.content.Context
import app.model.SourcesProvider
import app.model.accounts.AccountRepository
import app.model.accounts.AccountSource
import app.model.ads.AdsRepository
import app.model.ads.AdsSource
import app.model.chats.ChatsRepository
import app.model.chats.ChatsSource
import app.model.courses.CoursesRepository
import app.model.courses.CoursesSource
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

    private val chatsSource: ChatsSource by lazy {
        sourcesProvider.getChatsSource()
    }

    private val coursesSource: CoursesSource by lazy {
        sourcesProvider.getCoursesSource()
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

    val chatsRepository: ChatsRepository by lazy {
        ChatsRepository(
            chatsSource = chatsSource
        )
    }

    val coursesRepository: CoursesRepository by lazy {
        CoursesRepository(
            coursesSource = coursesSource
        )
    }

    fun init(appContext: Context) {
        Singletons.appContext = appContext
    }
}