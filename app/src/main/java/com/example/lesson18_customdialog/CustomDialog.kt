package com.example.lesson18_customdialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.dialog_area.*

class CustomDialog(context: Context,var activity: MainActivity) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_area)

        recyclerView.adapter = activity.adapter
        recyclerView.layoutManager = GridLayoutManager(context,4)
        activity.setData()

        btnAdd.setOnClickListener {
            activity.pressedEdit()
            dismiss()
        }
        btnCancel.setOnClickListener {
            dismiss()
        }
    }
}