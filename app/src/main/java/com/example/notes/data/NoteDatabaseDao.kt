package com.example.notes.data

import androidx.room.*
import com.example.notes.model.Note

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * FROM notes_table")
    fun getNotes(): List<Note>

    @Query("SELECT * FROM notes_table WHERE id = :id") //:id means id we're gonna pass
    fun getNoteById(id: String) : Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(note: Note)

    @Query("DELETE FROM notes_table")
    fun deleteAll()
    
    @Delete
    fun deleteNote(note: Note)

}
