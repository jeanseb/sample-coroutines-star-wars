package sample.coroutines.di

import dagger.Component
import sample.coroutines.StarWarsApi

@Component(modules = [AppModule::class])
interface AppComponent {

    fun starWarsApi(): StarWarsApi

}
