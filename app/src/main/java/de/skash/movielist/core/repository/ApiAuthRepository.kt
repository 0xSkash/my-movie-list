package de.skash.movielist.core.repository

import de.skash.movielist.core.api.AuthApi
import de.skash.movielist.core.model.User
import de.skash.movielist.core.util.Result
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class ApiAuthRepository @Inject constructor(
    private val authApi: AuthApi
) : AuthRepository {

    override fun login(email: String, password: String): Observable<Result<User>> {
        TODO("Not yet implemented")
    }
}