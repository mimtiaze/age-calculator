package com.mimtiaze.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    private val todayCal: Calendar = Calendar.getInstance()
    private val year = todayCal.get(Calendar.YEAR)
    private val month = todayCal.get(Calendar.MONTH)
    private val day = todayCal.get(Calendar.DAY_OF_MONTH)
    private lateinit var dateYear: TextView
    private lateinit var dateMonth: TextView
    private lateinit var dateDay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        val bDayButton : Button = findViewById(R.id.bdayButton)
        dateYear = findViewById(R.id.dateYear)
        dateMonth = findViewById(R.id.dateMonth)
        dateDay = findViewById(R.id.dateDays)

        bDayButton.setOnClickListener(View.OnClickListener {
            createDatePicker()
        })
    }

    private fun createDatePicker() {
        val dpd = DatePickerDialog(this, this, year, month, day)
        dpd.show()
    }

    override fun onDateSet(view: DatePicker?, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int) {
        //Toast.makeText(this, "${month+1}/$dayOfMonth/$year", Toast.LENGTH_SHORT).show()

        var passedYear =  year - selectedYear
        var passedMonth = month - selectedMonth
        var passedDay = day - selectedDayOfMonth

        dateYear.text = passedYear.toString()
        dateMonth.text = passedMonth.toString()
        dateDay.text = passedDay.toString()

        Toast.makeText(this, "Your are $passedYear years, $passedMonth months, $passedDay days old", Toast.LENGTH_SHORT).show()
    }
}