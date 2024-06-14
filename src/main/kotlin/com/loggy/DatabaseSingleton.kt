package com.loggy

import com.loggy.domains.inventory.models.Brands
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseSingleton{
    fun init(){
        val driverClassName = "org.sqlite.JDBC"
        val url = "jdbc:sqlite:H:/Code/SQLITE/LoggyDB.db"
        val db = Database.connect(url, driverClassName)
        // Creación de la tabla Brands
        transaction(db){
            SchemaUtils.create(Brands)
        }
    }
    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}