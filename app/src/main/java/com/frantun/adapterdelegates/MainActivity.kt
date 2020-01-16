package com.frantun.adapterdelegates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.recyclerview.widget.LinearLayoutManager
import com.frantun.adapterdelegates.delegate.bannerAdapterDelegate
import com.frantun.adapterdelegates.delegate.headerAdapterDelegate
import com.frantun.adapterdelegates.delegate.petAdapterDelegate
import com.frantun.adapterdelegates.model.Banner
import com.frantun.adapterdelegates.model.BaseModel
import com.frantun.adapterdelegates.model.Header
import com.frantun.adapterdelegates.model.Pet
import com.frantun.adapterdelegates.util.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUI()
    }

    private fun setUI() {
        val adapter = ListDelegationAdapter<List<BaseModel>>(
            headerAdapterDelegate(),
            petAdapterDelegate(),
            bannerAdapterDelegate {
                Toast.makeText(this, it.title, LENGTH_SHORT).show()
            }
        )

        rccRecycler.setHasFixedSize(true)
        rccRecycler.layoutManager = LinearLayoutManager(this)

        val header = getHeader()
        val pets = retrievePets()
        val banners = retrieveBanners()

        for (item in banners) {
            pets.add((0 until pets.size).random(), item)
        }

        adapter.items = listOf(header).plus(pets)
        rccRecycler.adapter = adapter
    }

    private fun getHeader(): Header {
        val header = Header()
        header.src = R.drawable.russian_cat

        return header
    }

    private fun retrievePets(): ArrayList<BaseModel> {
        val dataJSONString = Utils.getAssetJSONData(this, "pets.json")
        val type = object : TypeToken<List<Pet>>() {}.type

        return Gson().fromJson(dataJSONString, type)
    }

    private fun retrieveBanners(): ArrayList<BaseModel> {
        val dataJSONString = Utils.getAssetJSONData(this, "banners.json")
        val type = object : TypeToken<List<Banner>>() {}.type

        return Gson().fromJson(dataJSONString, type)
    }
}
