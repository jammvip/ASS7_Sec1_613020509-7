package com.example.ass7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.*
import kotlinx.android.synthetic.main.add_employee_layout.*
import kotlinx.android.synthetic.main.add_employee_layout.btnAdd
import kotlinx.android.synthetic.main.add_employee_layout.btnCancel
import kotlinx.android.synthetic.main.add_employee_layout.edt_name
import kotlinx.android.synthetic.main.add_employee_layout.edt_salary
import kotlinx.android.synthetic.main.add_employee_layout.radioGroup

class MainActivity : AppCompatActivity() {
    val EmployeeList = arrayListOf<Employee>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        employeeData()
        recycler_view.adapter = EmployeeAdapter(this.EmployeeList, applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
        recycler_view.itemAnimator = DefaultItemAnimator()
    }

    fun employeeData(){
        EmployeeList.add(Employee("Danny","Male","danny@kku.ac.th", 30000))
        EmployeeList.add(Employee("Sara","Female","sara@kku.ac.th", 34000))
    }

    fun addEmployee(view: View) {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout, null)
        val myBuilder = AlertDialog.Builder(this)
        myBuilder.setView(mDialogView)
        val mAlertDialog = myBuilder.show()
        mAlertDialog.btnAdd.setOnClickListener(){
            val radioGroupId: Int = mAlertDialog.radioGroup.checkedRadioButtonId
            val selected: RadioButton? = mAlertDialog.findViewById(radioGroupId)
            EmployeeList.add(
                Employee(
                    mAlertDialog.edt_name.text.toString(),
                    selected?.text.toString(),
                    mAlertDialog.edt_email.text.toString(),
                    mAlertDialog.edt_salary.text.toString().toInt()
                )
            )
            recycler_view.adapter?.notifyDataSetChanged()
            Toast.makeText(
                applicationContext,
                "The student is added successfully",
                Toast.LENGTH_LONG
            ).show()
            mAlertDialog.dismiss()
        }
        mAlertDialog.btnCancel.setOnClickListener(){
            mAlertDialog.dismiss()
        }

    }
}