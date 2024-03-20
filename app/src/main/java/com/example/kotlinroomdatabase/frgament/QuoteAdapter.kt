package com.example.kotlinroomdatabase.frgament

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinroomdatabase.R
import com.example.kotlinroomdatabase.frgament.QuoteAdapter.*
import com.example.kotlinroomdatabase.models.Quote
import com.example.kotlinroomdatabase.models.QuoteList
import kotlinx.android.synthetic.main.item_layout.view.*


class QuoteAdapter(private val quotes : ArrayList<Quote>) : RecyclerView.Adapter<QuoteViewHolder>() {

    class QuoteViewHolder(itemView :  View)  : RecyclerView.ViewHolder(itemView){

        fun bind(quote: Quote) {
            itemView.textViewUserName.text = quote.content
            itemView.textViewUserEmail.text = quote.author

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        QuoteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = quotes.size

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) =
        holder.bind(quotes[position])

    fun addData(list: List<Quote>) {
        quotes.addAll(list)
    }
}