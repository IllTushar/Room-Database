package com.example.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = EntityClass.class, exportSchema = false, version = 1)
public abstract class DatabaseRequestClass extends RoomDatabase {
    private static final String DB_NAME = "expense_table";
    private static DatabaseRequestClass entityClassInstance;

    public static synchronized DatabaseRequestClass getDB(Context context) {
        if (entityClassInstance == null) {
            entityClassInstance = Room.databaseBuilder(context, DatabaseRequestClass.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();

        }
        return entityClassInstance;
    }
    public abstract DaoInterface dao();
}
