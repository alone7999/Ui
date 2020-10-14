package dev.armoury.android.utils

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.core.app.ActivityCompat

open class ArmouryIntentUtils {

    fun openWebPage(context: Context, url: String?) {
        url?.let {
            val webPage = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, webPage)
            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
            }
        }
    }

    fun hasWriteExternalPermission(context: Context) =
        hasPermission(
            context = context,
            permission = Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

    fun getOpenWebPageInt(context: Context, url: String?): Intent? {
        val webPage = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webPage)
        return if (intent.resolveActivity(context.packageManager) != null) {
            intent
        } else {
            null
        }
    }

    fun getShareTextIntent(context: Context, text: String?): Intent? {
        return text?.let {
            val shareTextIntent = Intent(Intent.ACTION_SEND)
            shareTextIntent.type = "text/plain"
            shareTextIntent.putExtra(Intent.EXTRA_TEXT, it)
            if (shareTextIntent.resolveActivity(context.packageManager) != null) shareTextIntent else null
        }
    }

    private fun hasPermission(context: Context, permission: String) =
        ActivityCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED


}