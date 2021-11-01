package com.florian.gustin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.florian.gustin.presentation.RecyclerView.ListAdapter
import kotlinx.android.synthetic.main.activity_recycler.*
import kotlinx.android.synthetic.main.list_item_cell.view.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val days = List(30, {day -> "${
            Calendar.getInstance().run {
            set(Calendar.DAY_OF_WEEK, day)
            get(Calendar.DAY_OF_WEEK)
        }}"})

        main_list.run {
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            adapter = ListAdapter(days)
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        }
    }

}

