package footballclub.submissions.dicoding.app.footballclub.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import footballclub.submissions.dicoding.app.footballclub.data.FootBallClub
import footballclub.submissions.dicoding.app.footballclub.layouts.InlineImageAndLabelItemView
import org.jetbrains.anko.AnkoContext

class InlineImageAndLabelRecyclerViewAdapter(private val clubsData: MutableList<FootBallClub>, private val listener: (FootBallClub) -> Unit) : RecyclerView.Adapter<InlineImageAndLabelRecyclerViewAdapter.ViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
      ViewHolder(
          InlineImageAndLabelItemView()
              .createView(AnkoContext
                  .create(parent.context, parent)), listener)

  override fun getItemCount(): Int = clubsData.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) =
      holder.bindItem(getItem(position))

  private fun getItem(position: Int) = clubsData[position]

  class ViewHolder(val view: View, private val listener: (FootBallClub) -> Unit) : RecyclerView.ViewHolder(view) {

    private var lblName: TextView = itemView.findViewById(InlineImageAndLabelItemView.lblName)
    private var ivImage: ImageView = itemView.findViewById(InlineImageAndLabelItemView.ivImage)

    fun bindItem(data: FootBallClub) {
      lblName.text = data.name
      Glide.with(itemView.context).load(data.logo).into(ivImage)
      itemView.setOnClickListener { listener(data) }
    }
  }
}