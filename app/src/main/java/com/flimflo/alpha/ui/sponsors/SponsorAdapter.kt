package com.flimflo.alpha.ui.sponsors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flimflo.alpha.R
import kotlinx.android.synthetic.main.sponsor_item.view.*

class SponsorAdapter (val sponsor:List<Sponsors>):RecyclerView.Adapter<SponsorAdapter.SponsorHolder>(){


    class SponsorHolder(val view: View):RecyclerView.ViewHolder(view){
        fun render(sponsor: Sponsors){
            view.txtDatosCont.text = sponsor.contacto
            view.txtDatosDir.text = sponsor.direccion
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SponsorHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SponsorHolder(layoutInflater.inflate(R.layout.sponsor_item,parent,false))
    }

    override fun onBindViewHolder(holder: SponsorHolder, position: Int) {
        holder.render(sponsor[position])
    }

    override fun getItemCount(): Int = sponsor.size

}
