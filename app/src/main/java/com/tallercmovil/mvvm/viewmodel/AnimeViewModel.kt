package com.tallercmovil.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tallercmovil.mvvm.model.AnimeModel
import com.tallercmovil.mvvm.model.AnimeProvider

class AnimeViewModel: ViewModel() {

    //agregando un LiveData
    val animeModel = MutableLiveData<AnimeModel>()  //Este valor va a ir mutando
    val test = MutableLiveData<String>()

    fun updateAnime(){
        val currentAnime = AnimeProvider.getAnime()
        //En el código de abajo el ViewModel le avisa a la activity
        //que han habido cambios y la activity lo recibe con el observer
        animeModel.postValue(currentAnime)
    }


}