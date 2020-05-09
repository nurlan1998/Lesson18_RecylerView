package com.example.lesson18_customdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.item.*

class MainActivity : AppCompatActivity() {

    companion object{
        var checked = 0
    }

    var models: MutableList<PersonalArea> = mutableListOf()
    var adapter: ListAdapter = ListAdapter(this, this)
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item)

        val dialog = CustomDialog(this, this)

        tvPressQuarter.setOnClickListener {
            checked = 1
            dialog.show()
        }
        tvPressHouse.setOnClickListener {
            checked = 2
            dialog.show()
        }
        tvPressFlat.setOnClickListener {
            checked = 3
            dialog.show()
        }
    }

    fun setData() {
        for (i in 0 until 71) {
            var personalArea = PersonalArea()
            personalArea.area = "${i + 1}"
            models.add(personalArea)
        }
        adapter.setData(models)
    }

    fun selected(position: Int) {
        Toast.makeText(this, "selected:${position+1}", Toast.LENGTH_SHORT).show()
        count = position
    }

    fun pressedEdit(){
        when(checked){
            1 ->{tvPressQuarter.setText("Квартал:${count+1}")}
            2->{tvPressHouse.setText("Дом:${count+1}")}
            3 ->tvPressFlat.setText("Квартира:${count+1}")
        }
    }
}
