package com.example.retrotr.view.dialog

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
object Dialog{
    fun show(
        context: Context,
        dialogTitle:Int,
        dialogMessage:Int,
        dialogPositiveText:Int,
        onPositive:() -> Unit = {},
        dialogNegativeText:Int,
        onNegative:() -> Unit = {}
    ) = AlertDialog.Builder(context)
        .setTitle(dialogTitle)
        .setMessage(dialogMessage)
        .setPositiveButton(dialogPositiveText) {_,_->onPositive()}
        .setNegativeButton(dialogNegativeText) {_,_->onNegative()}
        .create()
        .show()
}

//object Dialog {
//
//    fun show(
//        context: Context,
//        dialogTitle: Int,
//        dialogMessage: Int,
//        dialogPositiveText: Int,
//        onPositive: () -> Unit = {},
//        dialogNegativeText: Int,
//        onNegative: () -> Unit = {}
//    ) = AlertDialog.Builder(context)
//        .setTitle(dialogTitle).setMessage(dialogMessage)
//        .setPositiveButton(dialogPositiveText) { _, _ -> onPositive() }
//        .setNegativeButton(dialogNegativeText) { _, _ -> onNegative() }
//        .create()
//        .show()
//}