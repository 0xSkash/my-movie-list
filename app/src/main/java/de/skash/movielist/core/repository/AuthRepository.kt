package de.skash.movielist.core.repository

import de.skash.movielist.core.model.User
import de.skash.movielist.core.util.Result
import io.reactivex.rxjava3.core.Observable

interface AuthRepository {
    fun login(email: String, password: String): Observable<Result<User>>
}