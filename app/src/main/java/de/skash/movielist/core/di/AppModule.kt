package de.skash.movielist.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.skash.movielist.BuildConfig
import de.skash.movielist.core.api.AuthApi
import de.skash.movielist.core.repository.AuthRepository
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BackgroundScheduler

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ComputationScheduler

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(createHttpClient())
        .baseUrl(BuildConfig.BASE_URL)
        .build()

    @Singleton
    @Provides
    fun provideAuthRepository(): AuthRepository {
        TODO()
    }

    @Singleton
    @Provides
    fun provideAuthApi(): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }

    @Provides
    @BackgroundScheduler
    fun provideBackgroundScheduler(): Scheduler {
        return Schedulers.io()
    }

    @Provides
    @ComputationScheduler
    fun provideComputationScheduler(): Scheduler {
        return Schedulers.computation()
    }

    private fun createHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
    }

}
