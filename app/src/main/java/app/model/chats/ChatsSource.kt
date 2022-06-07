package app.model.chats


import app.model.chats.entities.Chat

interface ChatsSource {
    suspend fun getChats(): List<Chat>
}
