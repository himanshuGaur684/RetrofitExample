package gaur.himanshu.retrofitexample

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso

class CountryAdapter(val context: Context):RecyclerView.Adapter<CountryAdapter.MyViewHolder>() {

    lateinit var list:List<CountryDetails>

    fun setContentList(list:List<CountryDetails>){
        this.list=list
        notifyDataSetChanged()
    }


    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){

        var names=itemView.findViewById<TextView>(R.id.country_name)
        var images=itemView.findViewById<RoundedImageView>(R.id.images)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.names.text=list[position].countryName
        Glide.with(context).load(list[position].population).into(holder.images)
       // Picasso.get().load(list[position].flags).into(holder.images)
    }
}