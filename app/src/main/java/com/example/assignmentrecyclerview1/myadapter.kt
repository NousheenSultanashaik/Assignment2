package com.example.assignmentrecyclerview1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val dataHolder: ArrayList<Model>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var dName: TextView = itemView.findViewById(R.id.displayname)
        var dEmail: TextView = itemView.findViewById(R.id.displayemail)
        var dGender: TextView = itemView.findViewById(R.id.displaygender)
        var dBtechPassoutYear: TextView = itemView.findViewById(R.id.displaybtechpassoutyear)
        var dDob: TextView = itemView.findViewById(R.id.displaydob)
        var dDateTime: TextView = itemView.findViewById(R.id.displaydateandtime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.singlerow, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.dName.text = dataHolder[position].name
        holder.dEmail.text = dataHolder[position].email
        holder.dGender.text = dataHolder[position].gender
        holder.dBtechPassoutYear.text = dataHolder[position].btechpassoutyear
        holder.dDob.text = dataHolder[position].dob
        holder.dDateTime.text = dataHolder[position].dateTime
    }

    override fun getItemCount(): Int {
        return dataHolder.size
    }
}