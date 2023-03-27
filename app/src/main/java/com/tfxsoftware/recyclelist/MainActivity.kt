package com.tfxsoftware.recyclelist

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import okhttp3.internal.wait
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private val contacts = Contacts()
    private var list = contacts.list
    private var adapter = ContactsAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = adapter
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            contacts.fetchData()
            list = contacts.list
            adapter = ContactsAdapter(list)
            recyclerView.adapter = adapter
        }

    }
}
