package com.example.a631k.data

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Eldor Turgunov on 25.06.2022.
 * 6.3.1k
 * eldorturgunov777@gmail.com
 */
@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String
)
