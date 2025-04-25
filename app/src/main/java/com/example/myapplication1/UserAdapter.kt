package com.example.myapplication1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication1.databinding.ItemHeaderLayoutBinding
import com.example.myapplication1.databinding.ItemLayoutBinding

class UserAdapter(val users: List<User>) :
    ListAdapter<User, ViewHolder>(UserDiffUtilCallback()) {

    class UserViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): UserViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemLayoutBinding.inflate(layoutInflater, parent, false)
                return UserViewHolder(binding)
            }
        }
    }

    class HeaderViewHolder(val binding: ItemHeaderLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): HeaderViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemHeaderLayoutBinding.inflate(layoutInflater, parent, false)
                return HeaderViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == 1) return UserViewHolder.from(parent)
        else return HeaderViewHolder.from(parent)
    }

    override fun getItemViewType(position: Int): Int {
        return users[position].type
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        if (holder is UserViewHolder) {
            holder.binding.tvName.text = user.name
            holder.binding.tvEmail.text = user.email
        } else if (holder is HeaderViewHolder) {
            holder.binding.tvHeader.text = user.name
        }
    }


    class UserDiffUtilCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
}