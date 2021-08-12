package com.androidizate.clase8.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidizate.clase8.R
import com.androidizate.clase8.data.datasources.remote.dtos.Photo
import java.util.*

/**
 * Created by andres.oller on 18/08/17.
 */
class PhotosAdapter(
    private val photoList: List<Photo> = ArrayList()
) : RecyclerView.Adapter<PhotosAdapter.ViewHolder?>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photoList[position]
        holder.setInfo(photo)
    }

    override fun getItemCount(): Int = photoList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setInfo(photo: Photo) {
            /*itemView.title.text = photo.title
            Glide.with(itemView.context)
                .load(photo.url)
                .dontAnimate()
                .into(itemView.image)*/
        }
    }
}
