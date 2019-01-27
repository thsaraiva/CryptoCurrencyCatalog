package com.example.tsaraiva.cryptocurrencycatalog.ui.utils

import com.example.tsaraiva.cryptocurrencycatalog.model.Currency
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class CurrencyJSONConverter {

    private val moshi by lazy { Moshi.Builder().build() }

    private val adapter by lazy {
        moshi.adapter(Currency::class.java)
    }

    private val listAdapter: JsonAdapter<List<Currency>> by lazy {
        moshi.adapter<List<Currency>>(Types.newParameterizedType(List::class.java, Currency::class.java))
    }

    fun toJson(currency: Currency) = adapter.toJson(currency)

    fun fromJSON(json: String) = adapter.fromJson(json)

    fun toJsonFromList(currencyList: List<Currency>) = listAdapter.toJson(currencyList)

    fun convertListFromJSON(json: String) = listAdapter.fromJson(json)
}