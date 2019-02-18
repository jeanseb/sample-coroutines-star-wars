package sample.coroutines

import kotlinx.coroutines.runBlocking
import sample.coroutines.di.DaggerAppComponent

fun main() = runBlocking {
    val starWarsApi = DaggerAppComponent.create().starWarsApi()

    val planet = starWarsApi.getPlanetAsync(3).await()
    println(planet)
}
