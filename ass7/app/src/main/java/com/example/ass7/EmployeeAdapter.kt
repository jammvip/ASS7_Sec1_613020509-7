package com.example.ass7

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter (val item: List<Employee>, val context: Context): RecyclerView.Adapter<ViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view_item = LayoutInflater.from(parent.context).inflate(R.layout.emp_item_layout,parent,false)
        return ViewHolder(view_item)
    }
    override fun getItemCount(): Int {
        return item.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = "Name : "+ item[position].EmpName
        holder.tvGender.text = "gender : "+ item[position].gender
        holder.tvEmail.text = "E-mail : "+ item[position].email
        holder.tvSalary.text = "Salary : "+ item[position].salary.toString()
    }
}