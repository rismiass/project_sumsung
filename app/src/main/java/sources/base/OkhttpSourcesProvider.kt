package sources.base

import app.model.SourcesProvider
import app.model.accounts.AccountSource
import sources.accounts.OkhttpAccountSource

class OkhttpSourcesProvider(
    private val config: OkhttpConfig
): SourcesProvider {
    override fun getAccountSource(): AccountSource {
        return OkhttpAccountSource(config)
    }
}