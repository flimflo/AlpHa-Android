package com.flimflo.alpha.ui.sponsors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.flimflo.alpha.R
import kotlinx.android.synthetic.main.fragment_sponsors.*

class SponsorsFragment : Fragment() {

    val sponsors: List<Sponsors> = listOf(
        Sponsors("Tel 1: 01 (474) 746 7076\n" + "Tel 2: 01 (474) 746 7077\n" + "correo: recepcion@eml.com.mx","Carr. Lagos-San Juan km 3 S/N\n" +
                "Col. Jacales\n" +
                "CP: 47470\n" +
                "Lagos de Moreno, Jal."),
        Sponsors("Tel: 01 (474) 742 8199","Calle Canal #390\n" +
                "Col. Granadillas\n" +
                "CP: 47433"),
        Sponsors("Tel: 01 (474) 738 8716","Emiliano Zapata #325 A\n" +
                "Col. Centro\n" +
                "CP: 47400\n" +
                "Lagos de Moreno, Jal."),
        Sponsors("Tel: 474 108 2758\n" + "correo: recepcion@eml.com.mx","Calle Francisco I.Madero #484 timbre 4\n" +
                "Col. Centro\n" +
                "CP: 47400\n" +
                "Lagos de Moreno, Jal."),
        Sponsors("Tel: 01 (474) 742 4536\n" +
                "correo: ventas@sicc-bajio.com\n" + "correo: recepcion@eml.com.mx","Calle Limón #48\n" +
                "Col. Huertos Familiares San Pedro\n" +
                "CP: 47472\n" +
                "Lagos de Moreno, Jal."))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_sponsors, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        initRecycle()
        super.onActivityCreated(savedInstanceState)
    }
    fun initRecycle(){
        recSponsors.layoutManager = LinearLayoutManager(activity)
        val adapter = SponsorAdapter(sponsors)
        recSponsors.adapter = adapter
    }

}