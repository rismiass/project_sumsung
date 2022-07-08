package app.model.chats.entities

data class Chat(
    val id: Long,
    val sender: String,
    val lastMessage: String, val image: String)
