package com.example.assignmentrecyclerview1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fetchdata : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataholder: ArrayList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetchdata)

        recyclerView = findViewById(R.id.recview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val cursor = DbManager(this).readAllData()
        dataholder = ArrayList()

        while (cursor?.moveToNext() == true) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val gender = cursor.getString(cursor.getColumnIndexOrThrow("gender"))
            val dob = cursor.getString(cursor.getColumnIndexOrThrow("dob"))
            val dateTime = cursor.getString(cursor.getColumnIndexOrThrow("dateTime"))
            val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
            val btechPassoutYear = cursor.getString(cursor.getColumnIndexOrThrow("btechpassoutyear"))
            val obj = Model(id,name, gender, dob, dateTime, email, btechPassoutYear)
            dataholder.add(obj)
        }

        val adapter = MyAdapter(dataholder)
        recyclerView.adapter = adapter
    }
}