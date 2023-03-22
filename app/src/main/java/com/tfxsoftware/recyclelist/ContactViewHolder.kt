package com.tfxsoftware.recyclelist

import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    private val contactName: TextView = itemView.findViewById(R.id.contact_name)
    private val contactNumber: TextView = itemView.findViewById(R.id.contact_number)

    fun bind (contactEntry: ContactEntry){
        contactName.text = contactEntry.name
        contactNumber.text = contactEntry.number
    }
}