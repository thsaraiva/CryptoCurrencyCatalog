package com.example.tsaraiva.cryptocurrencycatalog.data

import com.example.tsaraiva.cryptocurrencycatalog.model.Currency

interface DataRepository {
    fun getCurrencies(jsonString: String): List<Currency>
}