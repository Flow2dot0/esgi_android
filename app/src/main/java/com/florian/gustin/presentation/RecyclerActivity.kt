package com.florian.gustin.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.florian.gustin.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recycler.*
import kotlinx.android.synthetic.main.list_item_cell.view.*
import java.util.*

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        val days = List(30, {day -> "${Calendar.getInstance().run {
            set(Calendar.DAY_OF_WEEK, day)
            get(Calendar.DAY_OF_WEEK)
        }}"})

        main_list.run {
            layoutManager = GridLayoutManager(this@RecyclerActivity, 3)
            adapter = ListAdapter()
            addItemDecoration(DividerItemDecoration(this@RecyclerActivity, DividerItemDecoration.VERTICAL))
        }
    }

}

class ListAdapter : RecyclerView.Adapter<ListItemCell>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemCell {
        return ListItemCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_cell, parent, false)
        )
    }

    override fun onBindViewHolder(cell: ListItemCell, position: Int) {
        cell.text.text = position.toString()
    }

    override fun getItemCount(): Int {
        return 40
    }

}

class ListItemCell(v: View) : RecyclerView.ViewHolder(v) {

    val text : TextView = v.text_cell

}
