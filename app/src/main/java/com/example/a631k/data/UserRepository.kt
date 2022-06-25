package com.example.a631k.data

import androidx.lifecycle.LiveData


/**
 * Created by Eldor Turgunov on 25.06.2022.
 * 6.3.1k
 * eldorturgunov777@gmail.com
 */
class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

}