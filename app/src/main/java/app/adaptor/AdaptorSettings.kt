package app.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.model.courses.entities.Course
import app.model.dataclasses.ItemSettings
import com.example.project.R

class AdaptorSettings(private val data: List<ItemSettings>, val context: Context):
    RecyclerView.Adapter<AdaptorSettings.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val root = itemView

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInFlater = LayoutInflater.from(parent.context)
        val view = layoutInFlater.inflate(R.layout.view_settings, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]
        val title = holder.root.findViewById<TextView>(R.id.name_settings_item)
        val settings = holder.root.findViewById<EditText>(R.id.text_settings_item)
        title.text = item.titleSettings
        settings.setText(item.textSettings)
    }

    override fun getItemCount(): Int {
        return data.size
    }


}