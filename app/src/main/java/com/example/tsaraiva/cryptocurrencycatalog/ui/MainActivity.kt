package com.example.tsaraiva.cryptocurrencycatalog.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.tsaraiva.cryptocurrencycatalog.R
import com.example.tsaraiva.cryptocurrencycatalog.model.Currency
import com.example.tsaraiva.cryptocurrencycatalog.ui.utils.CurrencyJSONConverter

class MainActivity : AppCompatActivity() {

    private val converter: CurrencyJSONConverter = CurrencyJSONConverter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Crypto Currency List"

        val recyclerView = findViewById<RecyclerView>(R.id.currencies_list)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CurrenciesAdapter(getCurrencyDataFromLocalJSONFile() ?: listOf())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.crypto_currencies_list_menu, menu)

        val searchMenuItem = menu?.findItem(R.id.action_search) as MenuItem

        searchMenuItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                Toast.makeText(this@MainActivity, "Search View Opened!", Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                Toast.makeText(this@MainActivity, "Search View Closed!", Toast.LENGTH_SHORT).show()
                return true
            }
        })

        // Configure the search info and add any event listeners...
        val searchView = searchMenuItem?.actionView as SearchView
        searchView.queryHint = "Search for crypto..."

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.action_filter -> {
                Toast.makeText(this, "Search Filter!", Toast.LENGTH_SHORT).show()
                startActivity(SecondActivity.getIntent(this))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getCurrencyDataFromLocalJSONFile(): List<Currency>? {
        val inputStream = resources.openRawResource(R.raw.currencies)
        val bufferedReader = inputStream.bufferedReader()
        val jsonFile = bufferedReader.use { it.readText() }
        return converter.convertListFromJSON(jsonFile)
    }
}


