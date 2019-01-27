package com.example.tsaraiva.cryptocurrencycatalog.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.tsaraiva.cryptocurrencycatalog.R
import com.example.tsaraiva.cryptocurrencycatalog.model.Currency
import com.example.tsaraiva.cryptocurrencycatalog.ui.utils.CurrencyJSONConverter

class MainActivity : AppCompatActivity() {

    private val converter: CurrencyJSONConverter = CurrencyJSONConverter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.currencies_list)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CurrenciesAdapter(getCurrencyDataFromLocalJSONFile() ?: listOf())
    }

    private fun getCurrencyDataFromLocalJSONFile(): List<Currency>? {
        val inputStream = resources.openRawResource(R.raw.currencies)
        val bufferedReader = inputStream.bufferedReader()
        val jsonFile = bufferedReader.use { it.readText() }
        return converter.convertListFromJSON(jsonFile)
    }
}


