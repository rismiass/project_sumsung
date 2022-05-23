package app

import app.model.SourcesProvider
import app.model.accounts.AccountRepository
import app.model.accounts.AccountSource
import sources.SourceProviderHolder

object Singletons {

    private val sourcesProvider: SourcesProvider by lazy {
        SourceProviderHolder.sourcesProvider
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
}