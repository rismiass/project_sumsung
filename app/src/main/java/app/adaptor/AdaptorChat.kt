package app.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R
import app.model.dataclasses.Chat
import java.util.ArrayList

public class AdaptorChat(private val data : ArrayList<Chat>, val context: Context) : RecyclerView.Adapter<AdaptorChat.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val root = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInFlater = LayoutInflater.from(parent.context)
        val view = layoutInFlater.inflate(R.layout.view_chat, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]
        val sender = holder.root.findViewById<TextView>(R.id.sender)
        val lastMessage = holder.root.findViewById<TextView>(R.id.last_message)
        val image = holder.root.findViewById<ImageView>(R.id.picture_sender)
        image.setImageResource(item.image)
        sender.text = item.sender
        lastMessage.text = item.lastMessage
    }

    override fun getItemCount(): Int {
        return data.size
    }

}