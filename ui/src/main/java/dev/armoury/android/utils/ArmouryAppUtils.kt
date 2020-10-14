package dev.armoury.android.utils

import android.content.Context
import android.content.Intent

open class ArmouryAppUtils {

    fun restartApplication(context: Context) {
        val intent = context.packageManager
            .getLaunchIntentForPackage(context.packageName)
            ?: return
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.applicationContext.startActivity(intent)
    }

}