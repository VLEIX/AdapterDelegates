package com.frantun.adapterdelegates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.frantun.adapterdelegates.delegate.petAdapterDelegate
import com.frantun.adapterdelegates.model.BaseModel
import com.frantun.adapterdelegates.model.Pet
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ListDelegationAdapter<List<BaseModel>>(
            petAdapterDelegate()
        )

        val pet = Pet()
        pet.name = "Miku"
        pet.specie = "Cat"


        rccRecycler.setHasFixedSize(true)
        rccRecycler.layoutManager = LinearLayoutManager(this)

        adapter.items = listOf(pet)
        rccRecycler.adapter = adapter
    }
}
