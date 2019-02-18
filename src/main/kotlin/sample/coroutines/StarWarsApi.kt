package sample.coroutines

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsApi {

    @GET("planets/{id}")
    fun getPlanetAsync(@Path("id") id: Int): Deferred<Planet>

}

data class Planet(
    val name: String,
    val diameter: Int
)
