package com.muruffin.cinemablossom

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.extractors.*
import com.lagradost.cloudstream3.utils.*

class Cinemablossom : MainAPI() {
    override var mainUrl = "https://cinemablossom.lat"
    override var name = "Cinemablossom"
    override val hasMainPage = true
    override val supportedTypes = setOf(TvType.Movie)

    override suspend fun getMainPage(page: Int): HomePageResponse {
        val home = listOf(
            MovieSearchResponse(
                name = "Hell House LLC Origins: The Carmichael Manor",
                url = "https://drive.google.com/file/d/1a3fDhjzaA8pX2BOZ_41rGab4g6z8zvIs/view?usp=drivesdk",
                apiName = this.name,
                type = TvType.Movie,
                posterUrl = "https://image.tmdb.org/t/p/original/bsd1ovBNOhYpQElhlZAqpMo51q6.jpg",
                year = 2016
            )
        )
        return HomePageResponse(listOf(HomePageList("Películas en latino 🌸", home)))
    }

    override suspend fun load(url: String): LoadResponse {
        return newMovieLoadResponse("Your Name", url, TvType.Movie) {
            posterUrl = "https://image.tmdb.org/t/p/w500/some_poster.jpg"
            year = 2016
            addSource(LoadData(url))
        }
    }
}