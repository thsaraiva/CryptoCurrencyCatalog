package com.example.tsaraiva.cryptocurrencycatalog.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tsaraiva.cryptocurrencycatalog.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.title = "Second Activity"

    }

    companion object {
        fun getIntent(context: Context) = Intent(context, SecondActivity::class.java)
    }

}