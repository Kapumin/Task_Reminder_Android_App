package com.paizuri.taskreminder.common.helpers

import android.app.Dialog
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.paizuri.taskreminder.R
import com.paizuri.taskreminder.common.extensions.setOnClick

class DialogManager {

    companion object {

        fun createDialog(activity: AppCompatActivity, title: String, onPositiveButtonClicked: () -> Unit) {
            val dialog = Dialog(activity)
            dialog.apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(true)
                setContentView(R.layout.base_dialog_layout)
            }
            val tvTitle = dialog.findViewById(R.id.tv_dialog_title) as TextView
            val tvCancel = dialog.findViewById<TextView>(R.id.tv_cancel)
            val tvConfirm = dialog.findViewById<TextView>(R.id.tv_confirm)
            tvTitle.text = title
            tvCancel.setOnClick {
                dialog.dismiss()
            }
            tvConfirm.setOnClick {
                onPositiveButtonClicked()
                dialog.dismiss()
            }
            dialog.show()
        }
    }
}