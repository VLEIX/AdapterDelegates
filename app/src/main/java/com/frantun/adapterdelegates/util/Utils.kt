package com.frantun.adapterdelegates.util

import android.content.Context
import java.io.IOException

object Utils {
    fun getAssetJSONData(context: Context, filename: String): String? {
        val json: String
        try {
            val inputStream = context.assets.open(filename)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.use { it.read(buffer) }
            json = String(buffer)
        } catch (ioException: IOException) {
            return null
        }

        return json
    }
}