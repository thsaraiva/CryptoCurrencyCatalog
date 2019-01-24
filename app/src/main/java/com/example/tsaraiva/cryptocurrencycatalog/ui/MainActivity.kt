package com.example.tsaraiva.cryptocurrencycatalog.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.tsaraiva.cryptocurrencycatalog.R
import com.example.tsaraiva.cryptocurrencycatalog.model.Currency

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.currencies_list)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CurrenciesAdapter(generateDummyCurrencyData(100))
    }

    private fun generateDummyCurrencyData(itemsNumber: Int): List<Currency> {
        with(mutableListOf<Currency>()) {
            for (id in 1..itemsNumber) {
                add(Currency(id, "Item_$id", "$", "slug"))
            }
            return this
        }
    }
}


