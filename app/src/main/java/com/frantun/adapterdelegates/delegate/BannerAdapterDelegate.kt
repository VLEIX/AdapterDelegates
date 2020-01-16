package com.frantun.adapterdelegates.delegate

import android.widget.TextView
import com.frantun.adapterdelegates.R
import com.frantun.adapterdelegates.model.Banner
import com.frantun.adapterdelegates.model.BaseModel
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate

fun bannerAdapterDelegate(itemClickedListener: (Banner) -> Unit) =
    adapterDelegate<Banner, BaseModel>(
        layout = R.layout.banner,
        on = { item: BaseModel, items: List<BaseModel>, position: Int ->
            item is Banner
        }
    ) {

        itemView.setOnClickListener {
            itemClickedListener(item)
        }

        val txtTitle: TextView = findViewById(R.id.txtTitle)
        val txtDescription: TextView = findViewById(R.id.txtDescription)

        bind {
            txtTitle.text = item.title
            txtDescription.text = item.description
        }
    }

