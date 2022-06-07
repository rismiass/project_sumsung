package app.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.model.ads.entities.Ad
import com.example.project.R


public class AdaptorAdvertisement(private val data : List<Ad>, val context: Context) : RecyclerView.Adapter<AdaptorAdvertisement.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val root = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInFlater = LayoutInflater.from(parent.context)
        val view = layoutInFlater.inflate(R.layout.view_advertisement, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]
        val profession = holder.root.findViewById<TextView>(R.id.text_profession)
        val salary = holder.root.findViewById<TextView>(R.id.text_salary)
        val workingDays = holder.root.findViewById<TextView>(R.id.text_work_days)
        val image = holder.root.findViewById<ImageView>(R.id.picture_work)
        image.setImageResource(item.image)
        profession.text = item.profession
        salary.text = item.salary
        workingDays.text = item.working_days
    }

    override fun getItemCount(): Int {
        return data.size
    }

}