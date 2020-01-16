package com.frantun.adapterdelegates.delegate

import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.frantun.adapterdelegates.R
import com.frantun.adapterdelegates.model.BaseModel
import com.frantun.adapterdelegates.model.Header
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate

fun headerAdapterDelegate() = adapterDelegate<Header, BaseModel>(
    layout = R.layout.header,
    on = { item: BaseModel, items: List<BaseModel>, position: Int ->
        item is Header
    }
) {
    val imgHeader: ImageView = findViewById(R.id.imgHeader)

    bind {
        imgHeader.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                item.src!!
            )
        )
    }
}

