package sample.coroutines.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import sample.coroutines.StarWarsApi

@Module
class AppModule {

    @Provides
    fun provideBaseUrl(): String = "https://swapi.co/api/"

    @Provides
    fun provideOkHttpClient(): OkHttpClient = with(OkHttpClient.Builder()) {
        addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.NONE })
        build()
    }

    @Provides
    fun provideRetrofit(baseUrl: String, okHttpClient: OkHttpClient): Retrofit = with(Retrofit.Builder()) {
        baseUrl(baseUrl)
        client(okHttpClient)
        addConverterFactory(MoshiConverterFactory.create())
        addCallAdapterFactory(CoroutineCallAdapterFactory())
        build()
    }

    @Provides
    fun provideStarWarsApi(retrofit: Retrofit): StarWarsApi = retrofit.create(StarWarsApi::class.java)

}
