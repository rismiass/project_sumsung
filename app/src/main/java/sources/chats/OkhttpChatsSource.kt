package sources.chats

import app.model.ads.AdsSource
import app.model.ads.entities.Ad
import app.model.chats.ChatsSource
import app.model.chats.entities.Chat
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.delay
import okhttp3.Request
import sources.ads.entities.GetAdResponseEntity
import sources.base.BaseOkhttpSource
import sources.base.OkhttpConfig
import sources.chats.entities.GetChatResponseEntity

class OkhttpChatsSource(
    config: OkhttpConfig
) : BaseOkhttpSource(config), ChatsSource  {
    override suspend fun getChats(): List<Chat> {
        delay(1000)
        val request = Request.Builder().get().endpoint("chats").build()
        val call = client.newCall(request)
        val typeToken = object : TypeToken<List<GetChatResponseEntity>>() {}
        val response = call.suspendEnqueue().parseJsonResponse(typeToken)
        return response.map { it.toChat() }
    }
}
