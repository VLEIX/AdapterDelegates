package com.frantun.adapterdelegates.delegate

import android.widget.TextView
import com.frantun.adapterdelegates.R
import com.frantun.adapterdelegates.model.BaseModel
import com.frantun.adapterdelegates.model.Pet
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate

fun petAdapterDelegate(itemClickedListener: (Pet) -> Unit) =
    adapterDelegate<Pet, BaseModel>(R.layout.pet) {
        val txtName: TextView = findViewById(R.id.txtName)
//    txtName.setCli { itemClickedListener(item) } // Item is automatically set for you. It's set lazily though (set in onBindViewHolder()). So only use it for deferred calls like clickListeners.

        bind { diffPayloads ->
            // diffPayloads is a List<Any> containing the Payload from your DiffUtils
            txtName.text = item.name // Item is of type Cat and is the current bound item.
        }
    }