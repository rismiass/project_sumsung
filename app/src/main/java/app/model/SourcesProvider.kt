package app.model

import app.model.accounts.AccountSource
import app.model.ads.AdsSource
import app.model.chats.ChatsSource
import app.model.courses.CoursesSource

interface SourcesProvider {
    fun getAccountSource(): AccountSource
    fun getAdsSource(): AdsSource
    fun getChatsSource(): ChatsSource
    fun getCoursesSource(): CoursesSource
}