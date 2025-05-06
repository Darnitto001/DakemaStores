package com.darnitto.dakemastores.repository

import com.darnitto.dakemastores.data.UserDao
import com.darnitto.dakemastores.model.User

class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(user: User) {
        userDao.registerUser(user)
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.loginUser(email, password)
    }
}