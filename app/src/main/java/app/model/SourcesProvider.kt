package app.model

import app.model.accounts.AccountSource

interface SourcesProvider {
    fun getAccountSource(): AccountSource
}