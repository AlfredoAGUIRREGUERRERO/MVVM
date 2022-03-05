package com.tallercmovil.mvvm.model

class AnimeProvider {
    companion object{

        private val animes = ArrayList<AnimeModel>()

        init{
            for(i in 1 until 20){
                val animeTmp = AnimeModel(i.toLong(), "Título $i", "Tipo $i", "Fecha $i")
                animes.add(animeTmp)
            }
        }

        fun getAnime(): AnimeModel{
            val position = (0..18).random()
            return animes[position]
        }

    }
}