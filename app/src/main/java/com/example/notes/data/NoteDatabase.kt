package com.example.notes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.notes.model.Note
import com.example.notes.util.DateConverter
import com.example.notes.util.UUIDConverter
/*
If you have any type that ROOM does know how to handle it, you have create converter for it and
then add it here @TypeConverters to tell ROOM how to handle it
 */
@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class,UUIDConverter::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}