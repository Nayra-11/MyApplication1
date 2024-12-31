package com.example.myapplication1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val users: List<User>)
    :RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    class UserViewHolder(val row:View) : RecyclerView.ViewHolder(row) {
        //hold views
        val tvName = row.findViewById<TextView>(R.id.tv_name)
        val tvEmail = row.findViewById<TextView>(R.id.tv_email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout,parent,false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]

        holder.tvName.text=user.name
        holder.tvEmail.text=user.email
    }
}