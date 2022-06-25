package com.example.a631k.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


/**
 * Created by Eldor Turgunov on 25.06.2022.
 * 6.3.1k
 * eldorturgunov777@gmail.com
 */
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: User)

    @Query("SELECT*FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>
}