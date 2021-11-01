package com.florian.gustin.presentation.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.florian.gustin.R
import kotlinx.android.synthetic.main.list_item_cell.view.*
import java.util.*


class ListAdapter(val days: List<String>) : RecyclerView.Adapter<ListItemCell>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemCell {
        return ListItemCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_cell, parent, false)
        )
    }

    override fun onBindViewHolder(cell: ListItemCell, position: Int) {
        cell.text.text = when(days[position].toInt()){
            Calendar.MONDAY->"Lundi"
            Calendar.TUESDAY->"Mardi"
            Calendar.WEDNESDAY->"Mercredi"
            Calendar.THURSDAY->"Jeudi"
            Calendar.FRIDAY->"Vendredi"
            Calendar.SATURDAY->"Samedi"
            Calendar.SUNDAY->"Dimanche"
            else -> "?"

        }
    }

    override fun getItemCount(): Int {
        return days.size
    }

}

class ListItemCell(v: View) : RecyclerView.ViewHolder(v) {

    val text : TextView = v.text_cell

}
