package com.mimtiaze.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import java.util.Calendar

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    private val myCalender: Calendar = Calendar.getInstance()
    private val year = myCalender.get(Calendar.YEAR)
    private val month = myCalender.get(Calendar.MONTH)
    private val day = myCalender.get(Calendar.DAY_OF_MONTH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        val bDayButton : Button = findViewById(R.id.bdayButton)
        bDayButton.setOnClickListener(View.OnClickListener {
            createDatePicker()
        })
    }

    private fun createDatePicker() {
        val dpd = DatePickerDialog(this, this, year, month, day)
        dpd.show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        //Toast.makeText(this, "${month+1}/$dayOfMonth/$year", Toast.LENGTH_SHORT).show()
    }
}