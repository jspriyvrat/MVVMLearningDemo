package com.example.mvvmlearning.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmlearning.R
import com.example.mvvmlearning.models.User

class MainAdapter(private val users: ArrayList<User>):RecyclerView.Adapter<MainAdapter.DataViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=DataViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false))


    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =holder.bind(users[position])
    fun addData(list: List<User>){
        users.addAll(list)
    }

    override fun getItemCount(): Int {
        return users.size
    }
    class DataViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        private val textViewUserName :TextView=itemView.findViewById(R.id.textViewUserName)
        private val  textViewUserEmail:TextView=itemView.findViewById(R.id.textViewUserEmail)
        private val imageViewAvatar:ImageView=itemView.findViewById(R.id.imageViewAvatar)
        fun bind(user: User) {
            textViewUserName.text = user.name
            textViewUserEmail.text = user.email
            Glide.with(imageViewAvatar.context)
                .load(user.avatar)
                .into(imageViewAvatar)
        }

    }
}