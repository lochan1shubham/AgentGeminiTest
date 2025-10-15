package com.example.agentgeminitest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val studentRecyclerView: RecyclerView = findViewById(R.id.student_recycler_view)
        studentRecyclerView.layoutManager = LinearLayoutManager(this)

        val studentList = ArrayList<Student>()
        studentList.add(Student("John Doe", 20))
        studentList.add(Student("Jane Smith", 22))
        studentList.add(Student("Peter Jones", 21))

        val studentAdapter = StudentAdapter(studentList)
        studentRecyclerView.adapter = studentAdapter
    }
}