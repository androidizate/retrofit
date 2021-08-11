package com.androidizate.clase8.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidizate.clase8.R
import com.androidizate.clase8.repositories.datasources.remote.dtos.Post
import com.androidizate.clase8.repositories.datasources.remote.dtos.User
import kotlinx.android.synthetic.main.card_user.view.*
import kotlinx.android.synthetic.main.card_user.view.name
import kotlinx.android.synthetic.main.card_user.view.user_id
import kotlinx.android.synthetic.main.card_user.view.username
import kotlinx.android.synthetic.main.item_post.view.*
import java.util.*

/**
 * Created by andres.oller on 18/08/17.
 */
class PostAdapter(private val postList: List<Post> = ArrayList()) : RecyclerView.Adapter<PostAdapter.ViewHolder?>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = postList[position]
        holder.setInfo(post)
    }

    override fun getItemCount(): Int = postList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setInfo(post: Post) {
            itemView.user_id.text = post.userId.toString()
            itemView.post_id.text = post.id.toString()
            itemView.title_id.text = post.title
            itemView.body_id.text = post.body

        }
    }
}