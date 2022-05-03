package com.zooperman.notekeeper

import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.zooperman.notekeeper.databinding.ActivityNoteListBinding
import com.zooperman.notekeeper.databinding.ContentNoteListBinding

class NoteListActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNoteListBinding
    private lateinit var contentBinding: ContentNoteListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoteListBinding.inflate(layoutInflater)
        contentBinding = ContentNoteListBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setContentView(contentBinding.root)

        setSupportActionBar(binding.toolbar)

//        val navController = findNavController(R.id.nav_host_fragment_content_note_list)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { _ ->
            val activityIntent = Intent(this, MainActivity::class.java)
            startActivity(activityIntent)

//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
        }

        val notesList = contentBinding.listNotes   //findViewById<ListView>(R.id.listNotes)
        notesList.adapter = ArrayAdapter<NoteInfo>(
            this,
            android.R.layout.simple_list_item_1,
            DataManager.notes
        )
        notesList.setOnItemClickListener { adapterView, view, i, l ->
            val activityIntent = Intent(this, MainActivity::class.java)
            activityIntent.putExtra(EXTRA_NOTE_POSITION, i)
            startActivity(activityIntent)
        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_note_list)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}