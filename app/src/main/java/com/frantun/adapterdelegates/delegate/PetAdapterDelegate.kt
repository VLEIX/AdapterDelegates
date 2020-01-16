package com.frantun.adapterdelegates.delegate

import android.widget.TextView
import com.frantun.adapterdelegates.R
import com.frantun.adapterdelegates.model.BaseModel
import com.frantun.adapterdelegates.model.Pet
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate

fun petAdapterDelegate() = adapterDelegate<Pet, BaseModel>(
    layout = R.layout.pet,
    on = { item: BaseModel, items: List<BaseModel>, position: Int ->
        item is Pet
    }
) {
    val txtName: TextView = findViewById(R.id.txtName)
    val txtSpecie: TextView = findViewById(R.id.txtSpecie)

    bind {
        txtName.text = item.name
        txtSpecie.text = item.specie
    }
}

