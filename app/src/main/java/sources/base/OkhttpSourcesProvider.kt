package sources.base

import app.model.SourcesProvider
import app.model.accounts.AccountSource
import app.model.ads.AdsSource
import app.model.chats.ChatsSource
import app.model.courses.CoursesSource
import sources.accounts.OkhttpAccountSource
import sources.ads.OkhttpAdsSource
import sources.chats.OkhttpChatsSource
import sources.courses.OkhttpCoursesSource

class OkhttpSourcesProvider(
    private val config: OkhttpConfig
): SourcesProvider {
    override fun getAccountSource(): AccountSource {
        return OkhttpAccountSource(config)
    }

    override fun getAdsSource(): AdsSource {
        return OkhttpAdsSource(config)
    }

    override fun getChatsSource(): ChatsSource {
        return OkhttpChatsSource(config)
    }

    override fun getCoursesSource(): CoursesSource {
        return OkhttpCoursesSource(config)
    }
}