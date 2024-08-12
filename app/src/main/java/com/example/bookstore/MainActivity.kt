package com.example.bookstore

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookstore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
                binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        enableEdgeToEdge()
    val BooksList = mutableListOf<Books>(
        Books(name = "One Hundred Years of Solitude", author = "Gabriel Garcia Marquez", image = R.drawable.solitude),
        Books(name = "Teraa Nostra", author = "Carlos Funets", image = R.drawable.nostra),
        Books(name = "Angels and Demons", author = "Dan Brown", image = R.drawable.angels),
        Books(name = "The Sword Thief", author = "Peter Learngis", image = R.drawable.sword),
        Books(name = "inferno", author = "Dan Brown", image = R.drawable.humming),
        Books(name = "Blood Line", author = "James Rollins", image = R.drawable.blood),
        Books(name = "The House of the Spirits", author = "Isabel Allende", image = R.drawable.spirits),

        )
               val bookAdapter = BookAdapter(BooksList)
        binding.rvBooks.layoutManager= LinearLayoutManager(this)
        binding.rvBooks.adapter=bookAdapter


        binding.toolbar.bellIcon.setOnClickListener {
            Toast.makeText(this,R.string.Notification_clicked, Toast.LENGTH_SHORT).show()
        }
                binding.toolbar.materialToolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }
    }
}