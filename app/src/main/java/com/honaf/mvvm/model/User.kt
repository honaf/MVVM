package com.honaf.mvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
class User constructor(id: Int, name: String = "Stefan") {
    @PrimaryKey()
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    var id: Int = 0

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    var name: String? = null

    @ColumnInfo(name = "avatar", typeAffinity = ColumnInfo.TEXT)
    @SerializedName("avatar-url")
    var avatar: String? = null

    @ColumnInfo(name = "followers", typeAffinity = ColumnInfo.INTEGER)
    var followers: Int = 0

    @ColumnInfo(name = "following", typeAffinity = ColumnInfo.INTEGER)
    var following: Int = 0

    @ColumnInfo(name = "blog", typeAffinity = ColumnInfo.TEXT)
    var blog: String? = null

    @ColumnInfo(name = "company", typeAffinity = ColumnInfo.TEXT)
    var company: String? = null

    @ColumnInfo(name = "bio", typeAffinity = ColumnInfo.TEXT)
    var bio: String? = null

    @ColumnInfo(name = "location", typeAffinity = ColumnInfo.TEXT)
    var location: String? = null

    @ColumnInfo(name = "htmlUrl", typeAffinity = ColumnInfo.TEXT)
    var htmlUrl: String? = null

    init {
        this.id = id
        this.name = name
        this.avatar = avatar
    }

    override fun toString(): String {
        return "User(id=$id, name=$name, avatar=$avatar, followers=$followers, following=$following, blog=$blog, company=$company, bio=$bio, location=$location, htmlUrl=$htmlUrl)"
    }


}