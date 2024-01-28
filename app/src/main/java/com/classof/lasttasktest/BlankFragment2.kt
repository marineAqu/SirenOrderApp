package com.classof.lasttasktest

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class BlankFragment2 : Fragment() {

    lateinit var bakebagel: Button
    lateinit var bakebrownie: Button
    lateinit var bakecinna: Button
    lateinit var bakemacar: Button
    lateinit var bakewaff: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank2, container, false)

        bakebagel = view.findViewById(R.id.bakebagel)
        bakebrownie = view.findViewById(R.id.bakebrownie)
        bakecinna = view.findViewById(R.id.bakecinna)
        bakemacar = view.findViewById(R.id.bakemacar)
        bakewaff = view.findViewById(R.id.bakewaff)


        //비음료코드: 30
        bakebagel.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", bakebagel.text.toString())
            intent.putExtra("menuName", "bakebagel")
            intent.putExtra("menuNum", 30)
            startActivityForResult(intent, 0)
        }
        bakebrownie.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", bakebrownie.text.toString())
            intent.putExtra("menuName", "bakebrownie")
            intent.putExtra("menuNum", 30)
            startActivityForResult(intent, 0)
        }
        bakecinna.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", bakecinna.text.toString())
            intent.putExtra("menuName", "bakecinna")
            intent.putExtra("menuNum", 30)
            startActivityForResult(intent, 0)
        }
        bakemacar.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", bakemacar.text.toString())
            intent.putExtra("menuName", "bakemacar")
            intent.putExtra("menuNum", 30)
            startActivityForResult(intent, 0)
        }
        bakewaff.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", bakewaff.text.toString())
            intent.putExtra("menuName", "bakewaff")
            intent.putExtra("menuNum", 30)
            startActivityForResult(intent, 0)
        }
        return view
    }
}