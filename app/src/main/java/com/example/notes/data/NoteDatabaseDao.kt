package com.example.notes.data

import androidx.room.*
import com.example.notes.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * FROM notes_table")
    fun getNotes():
            Flow<List<Note>>
    //MutableState<List<Note>> will give lot of headaches
    // for that we have a data structure which will act as state i.e. Flow

    @Query("SELECT * FROM notes_table WHERE id = :id") //:id means id we're gonna pass
    suspend fun getNoteById(id: String) : Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("DELETE FROM notes_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: Note)

    //making function 'suspend' means if the fun takes too long to function
    //then suspend it or re-function
}
