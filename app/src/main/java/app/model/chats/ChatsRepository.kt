package app.model.chats

import app.model.BackendException
import app.model.InvalidCredentialsException
import app.model.chats.entities.Chat

class ChatsRepository(
    private val chatsSource: ChatsSource
) {
    suspend fun getChats(): List<Chat> {
        val lstChats = try {
            chatsSource.getChats()
        } catch (e: Exception) {
            if (e is BackendException && e.code == 401) {
                // map 401 error for sign-in to InvalidCredentialsException
                throw InvalidCredentialsException(e)
            } else {
                throw e
            }

        }
        return lstChats
    }
}