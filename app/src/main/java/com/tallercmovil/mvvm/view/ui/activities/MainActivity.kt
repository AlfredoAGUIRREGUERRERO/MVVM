package com.tallercmovil.mvvm.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.tallercmovil.mvvm.databinding.ActivityMainBinding
import com.tallercmovil.mvvm.model.AnimeModel
import com.tallercmovil.mvvm.view.adapter.AnimesAdapter
import com.tallercmovil.mvvm.viewmodel.AnimeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var animes = ArrayList<AnimeModel>()
    var i: Long = 1

    private val animeViewModel: AnimeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        animeViewModel.animeModel.observe(this, Observer {
             //val animeTmp = AnimeModel(i, it.titulo, it.tipo, it.fecha)
             //animes.add(animeTmp)

              animes.add(AnimeModel(i, it.titulo, it.tipo, it.fecha))
              i++

              binding.lv.adapter = AnimesAdapter(this, animes)
        })

    }

    fun click(view: View) {
        animeViewModel.updateAnime()
    }
}