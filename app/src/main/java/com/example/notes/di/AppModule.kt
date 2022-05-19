package com.example.notes.di

import android.content.Context
import androidx.room.Room
import com.example.notes.data.NoteDatabase
import com.example.notes.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
" Modules are used to add bindings to Hilt "
In other words, to tell Hilt how to provide instances of diff types

To create a database, we would need to use a 'builder' to create an instance of DB
bc we don't want a DB created everytime the app starts.
 */
/*
SingletonComponent means one source of truth and we don't want it to be created in 2 diff instances
 */
@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    //Singleton meaning we get only one instance of this particular item
    //Provides meaning that it will provide
    @Singleton
    @Provides
    fun provideNotesDao(noteDatabase: NoteDatabase): NoteDatabaseDao {
        return noteDatabase.noteDao()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(context, NoteDatabase::class.java, "notes_db")
            .fallbackToDestructiveMigration()
            .build()
    }
}