package com.androidizate.clase8.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidizate.clase8.databinding.CardUserBinding
import com.androidizate.clase8.repositories.datasources.remote.dtos.User
import java.util.*

/**
 * Created by andres.oller on 18/08/17.
 */
class UserAdapter(private val userList: List<User> = ArrayList()) :
    RecyclerView.Adapter<UserAdapter.ViewHolder?>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CardUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.setInfo(user)
    }

    override fun getItemCount(): Int = userList.size

    inner class ViewHolder(val binding: CardUserBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setInfo(user: User) {
            binding.userId.text = user.id.toString()
            binding.name.text = user.name
            binding.username.text = user.username
            binding.email.text = user.email
            binding.street.text = user.address.street
            binding.suite.text = user.address.suite
            binding.city.text = user.address.city
            binding.zipcode.text = user.address.zipcode
            binding.lat.text = user.address.geo.lat
            binding.lng.text = user.address.geo.lng
            binding.phone.text = user.phone
            binding.website.text = user.website
            binding.companyName.text = user.company.name
            binding.catchPhrase.text = user.company.catchPhrase
            binding.bs.text = user.company.bs
        }
    }
}