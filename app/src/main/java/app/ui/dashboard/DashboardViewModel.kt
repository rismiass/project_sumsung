package app.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.Singletons
import app.model.ads.AdsRepository
import app.model.ads.entities.Ad
import kotlinx.coroutines.runBlocking

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
    val adsRepository: AdsRepository = Singletons.adsRepository
    val listAds = runBlocking {
        adsRepository.getAds()
    }
}