package app.ui.subtract

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.Singletons
import app.model.ads.AdsRepository
import app.model.chats.ChatsRepository
import kotlinx.coroutines.runBlocking

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text


    val chatsRepository: ChatsRepository = Singletons.chatsRepository
    val listChats = runBlocking {
        chatsRepository.getChats()
    }
}