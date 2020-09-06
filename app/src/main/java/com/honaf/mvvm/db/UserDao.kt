package com.honaf.mvvm.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.honaf.mvvm.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User?)

    @Query("SELECT * FROM user WHERE name = :name")
    fun getUserByName(name: String?): LiveData<User?>?

    @Delete
    fun deleteStudent(user: User?)
}