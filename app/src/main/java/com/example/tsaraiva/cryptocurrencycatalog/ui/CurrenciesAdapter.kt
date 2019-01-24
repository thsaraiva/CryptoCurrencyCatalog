package com.example.tsaraiva.cryptocurrencycatalog.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tsaraiva.cryptocurrencycatalog.model.Currency

class CurrenciesAdapter(private val currencyList: List<Currency>) :
    RecyclerView.Adapter<CurrenciesAdapter.CurrencyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val listItemView =
            LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return CurrencyViewHolder(listItemView)
    }

    override fun getItemCount() = currencyList.size

    override fun onBindViewHolder(viewHolder: CurrencyViewHolder, index: Int) {
        viewHolder.bind(currencyList[index])
    }

    class CurrencyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title = view.findViewById<TextView>(android.R.id.text1)

        fun bind(currencyModel: Currency) {
            title.text = currencyModel.name
        }

    }
}