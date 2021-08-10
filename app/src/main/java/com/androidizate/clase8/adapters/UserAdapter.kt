package com.androidizate.clase8.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidizate.clase8.R
import com.androidizate.clase8.repositories.datasources.remote.dtos.User
import kotlinx.android.synthetic.main.card_user.view.*
import java.util.*

/**
 * Created by andres.oller on 18/08/17.
 */
class UserAdapter(private val userList: List<User> = ArrayList()) : RecyclerView.Adapter<UserAdapter.ViewHolder?>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_user, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.setInfo(user)
    }

    override fun getItemCount(): Int = userList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setInfo(user: User) {
            itemView.user_id.text = user.id.toString()
            itemView.name.text = user.name
            itemView.username.text = user.username
            itemView.email.text = user.email
            itemView.street.text = user.address.street
            itemView.suite.text = user.address.suite
            itemView.city.text = user.address.city
            itemView.zipcode.text = user.address.zipcode
            itemView.lat.text = user.address.geo.lat
            itemView.lng.text = user.address.geo.lng
            itemView.phone.text = user.phone
            itemView.website.text = user.website
            itemView.companyName.text = user.company.name
            itemView.catchPhrase.text = user.company.catchPhrase
            itemView.bs.text = user.company.bs
        }
    }
}