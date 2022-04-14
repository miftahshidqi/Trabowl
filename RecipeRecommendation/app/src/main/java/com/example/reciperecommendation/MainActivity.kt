package com.example.reciperecommendation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recipeName: TextView = findViewById(R.id.recipeName)
        val button = findViewById<Button>(R.id.button)
        var name: String = "Apricot chicken with chickpeas and sweet potato"

        button.setOnClickListener({
            //val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.taste.com.au/recipes/apricot-chicken-chickpeas-sweet-potato/f2bcbc0c-30d5-4a68-bbd3-d1993e662acd?r=recipes/lowfatrecipes&c=53b15009-0732-4041-8225-4a02912b67c5/Low%20fat%20recipes" ))
            val uri = Uri.parse("https://www.taste.com.au/recipes/apricot-chicken-chickpeas-sweet-potato/f2bcbc0c-30d5-4a68-bbd3-d1993e662acd?r=recipes/lowfatrecipes&c=53b15009-0732-4041-8225-4a02912b67c5/Low%20fat%20recipes")

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)

        })
    }
}