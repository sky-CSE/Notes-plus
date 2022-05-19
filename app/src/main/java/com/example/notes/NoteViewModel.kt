package com.example.notes

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.model.Note
import com.example.notes.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {
    //    private var noteList = mutableStateListOf<Note>()
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    //initialize with dummy data
    init {
        //what we're doing here is making multiple lanes so each process can work separately
        viewModelScope.launch(Dispatchers.IO) {

            repository.getAllNotes().distinctUntilChanged().collect { listOfNotes ->
                if (listOfNotes.isNullOrEmpty()) {
                    Log.d("Empty", ": Empty List")
                } else {
                    _noteList.value = listOfNotes
                }
            }
            // noteList.addAll(NotesDataSource().loadNotes())
        }
    }

    suspend fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }
    suspend fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }
    suspend fun removeNote(note: Note) = viewModelScope.launch { repository.deleteNote(note) }

}