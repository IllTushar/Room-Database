package com.example.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface DaoInterface
{
    @Query("select * from Expensetable")
    List<EntityClass>reteriveAllData();

    @Insert
    void insertData(EntityClass entityClass);

    @Delete
    void deleteData(EntityClass entityClass);

    @Update
    void updateData(EntityClass entityClass);
}
