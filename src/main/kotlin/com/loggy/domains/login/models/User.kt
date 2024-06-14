package com.loggy.domains.login.models

import org.jetbrains.exposed.sql.*


data class User (
    var userId: Int,
    var userName: String,
    var userPassword: String,
    var userProfile: Int,
    var userLine: Int,
    var userRole: Int
)

object Users: Table(){
    val userId = integer("user_id").autoIncrement()
    val userName = varchar("user_name", 50)
    val userPassword = varchar("user_password", 255)
    val userProfile = integer("user_profile")
    val userLine = integer("user_line").references(Lines.lineId)
    val userRole = integer("user_role")

    override val primaryKey = PrimaryKey(userId)
}
