package com.zooperman.notekeeper

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.zooperman.notekeeper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var notePosition = POSITION_NOT_SET
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        val adapterCourses = ArrayAdapter<CourseInfo>(
            this,
            android.R.layout.simple_spinner_item,
            DataManager.courses.values.toList()
        )
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

//        val spinnerCourseHandle = findViewById<Spinner>(R.id.spinnerCourses)
        val spinnerCourseHandle = binding.spinnerCourses
        spinnerCourseHandle.adapter = adapterCourses

        // an activity has access to its intent properties
        notePosition = intent.getIntExtra(EXTRA_NOTE_POSITION, POSITION_NOT_SET)

        if (notePosition != POSITION_NOT_SET) {
            displayNote()
        }
    }

    private fun displayNote() {
        val note = DataManager.notes[notePosition]
        val noteTitle = binding.textNoteTitle // findViewById<EditText>(R.id.textNoteTitle)
        noteTitle.setText(note.title)
        val noteText = binding.textNoteText //findViewById<EditText>(R.id.textNoteText)
        noteText.setText(note.text)

        val coursePosition = DataManager.courses.values.indexOf(note.course)
        val spinnerCourse = binding.spinnerCourses //findViewById<Spinner>(R.id.spinnerCourses)
        spinnerCourse.setSelection(coursePosition)
    }
}