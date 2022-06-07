package sources.chats.entities

import app.model.ads.entities.Ad
import app.model.chats.entities.Chat

data class GetChatResponseEntity(
    val id: Long,
    val sender: String,
    val lastMessage: String,
    val image: Int
) {
    fun toChat(): Chat = Chat(
        id =id,
        sender = sender,
        lastMessage = lastMessage,
        image  = image
    )
}


