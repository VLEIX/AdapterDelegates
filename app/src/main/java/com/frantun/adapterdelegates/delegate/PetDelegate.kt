package com.frantun.adapterdelegates.delegate

import android.widget.TextView
import com.frantun.adapterdelegates.R
import com.frantun.adapterdelegates.model.BaseModel
import com.frantun.adapterdelegates.model.Pet
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate

// top level function inside CatDelegate.kt
fun petAdapterDelegate() = adapterDelegate<Pet, BaseModel>(
    layout = R.layout.pet,
    on = { item: BaseModel, items: List<BaseModel>, position: Int ->
        true
    }
) {

    val txtName: TextView = findViewById(R.id.txtName)
    bind {
        txtName.text = item.name
    }
}

