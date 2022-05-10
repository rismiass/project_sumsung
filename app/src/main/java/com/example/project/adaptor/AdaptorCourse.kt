package com.example.project.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R
import com.example.project.model.Course
import java.util.ArrayList

public class AdaptorCourse(private val data : ArrayList<Course>, val context: Context) : RecyclerView.Adapter<AdaptorCourse.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val root = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInFlater = LayoutInflater.from(parent.context)
        val view = layoutInFlater.inflate(R.layout.course_view, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]
        val title = holder.root.findViewById<TextView>(R.id.text_profession)
        val price = holder.root.findViewById<TextView>(R.id.text_salary)
        val image = holder.root.findViewById<ImageView>(R.id.picture_work)
        image.setImageResource(item.image)
        title.text = item.title
        price.text = item.price
    }

    override fun getItemCount(): Int {
        return data.size
    }

}