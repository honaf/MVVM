package com.honaf.mvvm.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.honaf.mvvm.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao?

    companion object {
        private const val DATABASE_NAME = "user_db"
        private var databaseInstance: UserDatabase? = null
        @Synchronized
        fun getInstance(context: Context): UserDatabase? {
            if (databaseInstance == null) {
                databaseInstance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return databaseInstance
        }
    }
}