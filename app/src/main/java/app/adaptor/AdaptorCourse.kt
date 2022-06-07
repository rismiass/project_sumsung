package app.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.model.courses.entities.Course
import com.example.project.R
import java.util.ArrayList

public class AdaptorCourse(private val data : List<Course>, val context: Context) : RecyclerView.Adapter<AdaptorCourse.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val root = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInFlater = LayoutInflater.from(parent.context)
        val view = layoutInFlater.inflate(R.layout.view_course, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]
        val title = holder.root.findViewById<TextView>(R.id.title_course)
        val price = holder.root.findViewById<TextView>(R.id.price)
        val image = holder.root.findViewById<ImageView>(R.id.picture_course)
        image.setImageResource(item.image)
        title.text = item.title
        price.text = item.price
    }

    override fun getItemCount(): Int {
        return data.size
    }

}