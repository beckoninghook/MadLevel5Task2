package com.example.madlevel5task2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.*

@Entity(tableName = "gameTable")
class Game(

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "lastUpdated")
    var release: Date?,

    @ColumnInfo(name = "platform")
    var platform: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
)