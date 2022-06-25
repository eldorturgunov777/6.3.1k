package com.example.a631k

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a631k.adapter.MyAdapter
import com.example.a631k.data.User
import com.example.a631k.data.UserViewModel
import com.example.a631k.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var mUserViewModel: UserViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        fab = findViewById(R.id.fab)
        recyclerView.layoutManager = LinearLayoutManager(this)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        val adapter = MyAdapter()
        recyclerView.adapter = adapter
        mUserViewModel.readAllData.observe(this, Observer { user ->
            adapter.setData(user)
        })

        fab.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)
            val inflater = this.layoutInflater
            val mView = inflater.inflate(R.layout.dialog_page, null)
            val etEmail: EditText = mView.findViewById(R.id.etEmail)
            dialogBuilder.setView(mView)
            dialogBuilder.setPositiveButton(
                "SAVE"
            ) { p0, p1 ->

                val title = etEmail.text.toString()
                val user = User(0, title)
                mUserViewModel.addUser(user)
                Toast.makeText(this@MainActivity, "Sucses", Toast.LENGTH_SHORT).show()

            }
            dialogBuilder.setNegativeButton(
                "CANCEL"
            ) { p0, p1 ->

            }
            val alertDialog = dialogBuilder.create()
            alertDialog.show()
        }

    }
}