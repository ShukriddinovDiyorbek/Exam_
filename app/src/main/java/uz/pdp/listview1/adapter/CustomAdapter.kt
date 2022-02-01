package uz.pdp.listview1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.pdp.listview1.R
import uz.pdp.listview1.model.Member

class CustomAdapter(val members: List<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members[position]
        if(holder is CustomViewHolder){
            holder.img_rv.setImageResource(member.img_rv)
            holder.title_rv.setText(member.title_rv)
            holder.info_rv.setText(member.info_rv)
            holder.price.setText(member.price)
            holder.ratingbar.setRating(member.rate.toFloat())

        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val img_rv = itemView.findViewById<ImageView>(R.id.rw_img)
        val title_rv = itemView.findViewById<TextView>(R.id.rv_title)
        val info_rv = itemView.findViewById<TextView>(R.id.rv_info)
        val price = itemView.findViewById<TextView>(R.id.price)
        val ratingbar = itemView.findViewById<RatingBar>(R.id.ratingbar)
    }

}