package com.example.details_ui.utills

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri


fun Context.openYoutubeLink( url: String) {
    val intent = Intent(Intent.ACTION_VIEW, url.toUri())
    this.startActivity(intent)
}
