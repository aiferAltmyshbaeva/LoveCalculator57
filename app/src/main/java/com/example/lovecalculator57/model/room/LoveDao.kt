package com.example.lovecalculator57.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculator57.model.LoveModel

@Dao
interface LoveDao {
    @Query("SELECT * FROM love_table ORDER BY id DESC")
    fun getAll(): List<LoveModel>
    @Insert
    fun insert(loveModel: LoveModel)
}

