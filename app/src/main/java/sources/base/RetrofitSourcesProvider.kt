package sources.base

import app.model.SourcesProvider
import app.model.accounts.AccountSource
import sources.accounts.RetrofitAccountSource

class RetrofitSourcesProvider(
    private val config: RetrofitConfig
): SourcesProvider {
    override fun getAccountSource(): AccountSource {
        return RetrofitAccountSource(config)
    }
}