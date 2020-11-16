package com.flimflo.alpha.ui.rules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.flimflo.alpha.R


class RulesFragment : Fragment() {

    private var rulesList: MutableList<Rule> = mutableListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var rulesAdapter: RulesAdapter
    var ruleNumber:Int? = null
    var ruleTitle:String? = null
    var ruleImage: Int? = null
    var ruleDescription: MutableList<String> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_rules, container, false)

        loadRules()

        recyclerView = root.findViewById(R.id.recRules)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(), 2)
        }

        recyclerView.addItemDecoration(GridSpacingItemDecoration(2,100,false,0))

        rulesAdapter = RulesAdapter(requireContext(), rulesList)
        recyclerView.adapter = rulesAdapter

        return root
    }

    fun loadRules() {

        //Regla 1
        ruleNumber = rulesList.size + 1
        ruleTitle = "Tarjeta amarrilla y roja"
        ruleImage = R.drawable.regla_1

        ruleDescription.add("Al acumular tres tarjetas amarillas serán penalizadas: 1. Con un partido 2. Con una multa de 50 pesos.")
        ruleDescription.add("Cada tarjeta roja será penalizada con 70 pesos y la suspensión del jugador quedará a criterio del árbitro.")

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))
        //Regla 2
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "En las finales el horario estará sujeto a la decisión del equipo que haya quedado más arriba en la tabla."
        ruleImage = R.drawable.regla_2

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 3
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "La fecha límite para entregar los requisitos será la jornada 4."
        ruleImage = R.drawable.regla_3

        ruleDescription.add("A partir de la jornada 5 jugador que no presente credencial no podrá jugar.")
        ruleDescription.add("A partir de la jornada 5 el equipo deberá presentar uniforme completo.")

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 4
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "Se abrirá una segunda temporada de registros a la mitad del torneo con duración de 2 jornadas.  1 y 2 de la segunda vuelta."
        ruleImage = R.drawable.regla_4

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 5
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "En caso de alguna lesión extrema se apoyará al jugador con terapia profesional en caso de requerirla. Nota: no aplica si el jugador no cuenta con la indumentaria obligatoria véase reglas 5 y 6 del apartado DEPORTIVO."
        ruleImage = R.drawable.regla_5

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 6
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "Se solicitará una fianza de $400 la cual corresponderá a los arbitrajes de las 2 últimas jornadas. En caso de que se pierda por default el arbitraje se tomará de la fianza y a la siguiente jornada tendrá que ser recuperado por el equipo. La fianza tendrá que ser cubierta a más tardar en la jornada 4."
        ruleImage = R.drawable.regla_6

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 7
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "La fecha límite para cubrir la inscripción será la jornada 1."
        ruleImage = R.drawable.regla_7

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 8
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "Respetar las decisiones arbitrales."
        ruleImage = R.drawable.regla_8

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 9
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "El torneo se jugará a 2 vueltas."
        ruleImage = R.drawable.regla_9

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 10
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "Cada equipo participará con 7 jugadores dentro del campo. En caso de que el equipo no se complete, el partido podrá empezar con 5 jugadores."
        ruleImage = R.drawable.regla_10

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 11
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "Se podrán hacer sustituciones ilimitadas y los jugadores podrán volver a entrar, aunque haya sido sustituido previamente."
        ruleImage = R.drawable.regla_11

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 12
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "Los jugadores no podrán jugar con ningún objeto que pueda ser peligroso para ellos mismos o para los demás (piercings, aretes, collares)."
        ruleImage = R.drawable.regla_12

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 13
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "Cada jugador deberá traer: espinilleras, jersey, short, tachones."
        ruleImage = R.drawable.regla_13

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 14
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "Se jugarán 2 tiempos de 25(30) minutos con un descanso intermedio de 7 minutos. El tiempo comenzara a correr a partir del segundo silbatazo del árbitro. El tiempo no se repondrá si el partido comienza tarde. 15 min y 5 a los demás."
        ruleImage = R.drawable.regla_14

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 15
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "La cuenta de goleo en un solo partido se detendrá cuando haya una diferencia de 13 goles sin embargo el partido continuará hasta que se cumpla el tiempo reglamentario."
        ruleImage = R.drawable.regla_15

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 16
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "Solo se permite el acceso a la cancha a los jugadores, auxiliar y director técnico durante el partido."
        ruleImage = R.drawable.regla_16

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 17
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "Presentar 1 balon por equipo antes de comenzar el partido."
        ruleImage = R.drawable.regla_17

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 18
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "Tarjeta Amarilla: cuando un jugador sea amonestado tendrá que salir del partido durante 3 minutos, un relevo podrá entrar en su lugar en ese instante."
        ruleImage = R.drawable.regla_18

        ruleDescription.add("Si hay un segundo amonestado dentro de esos 3 minutos y el equipo solo tiene de cambio al primer amonestado, los 2 amonestados tendrán que cumplir con sus 3 respectivos minutos.")
        ruleDescription.add("Si hay un tercer amonestado dentro de esos 3 minutos, los amonestados podrán regresar al terreno de juego, pero se marcará un penal en su contra.")

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 19
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "Tarjeta Roja: el jugador tendrá que abandonar la cancha y no podrá volver a entrar durante ese partido. Otro jugador podrá sustituirlo, pero solo 5 minutos después de la expulsión. Si hay otro expulsado dentro de esos 5 minutos el relevo podrá ingresar inmediatamente pero el equipo quedará con 6 jugadores. Las sanciones por expulsión las impondrá el árbitro."
        ruleImage = R.drawable.regla_19

        ruleDescription.add("Si el partido termina por conato de bronca antes del tiempo establecido se resolverá como partido ganado por default. El equipo que no causo el conflicto será el ganador.")
        ruleDescription.add("Habrá una política de cero tolerancia a la violencia y en dado caso que exista agresión se expulsará definitivamente al jugador o al equipo según sea el caso.")

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 20
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "Al termino de cada partido el capitán o delegado de cada equipo se dirigirá con el arbitro para firmar la cédula de juego correspondiente, no se aceptarán reclamos posteriores si la cédula no está firmada."
        ruleImage = R.drawable.regla_20

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 21
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "No introducir bebidas alcohólicas dentro de la cancha."
        ruleImage = R.drawable.regla_21

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 22
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "Al detectar aliento alcohólico en algún jugador, previamente o durante el partido, será expulsado una jornada."
        ruleImage = R.drawable.regla_22

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))

        //Regla 23
        ruleDescription = mutableListOf()
        ruleNumber = rulesList.size + 1
        ruleTitle = "Cada delegado de equipo es responsable de mantener el orden de su plantel."
        ruleImage = R.drawable.regla_23

        rulesList.add(Rule(ruleNumber!!, ruleTitle!!, ruleImage!!,ruleDescription))
    }
}
