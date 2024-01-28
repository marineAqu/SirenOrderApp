package com.classof.lasttasktest

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class BlankFragment3 : Fragment() {

    lateinit var cakechoco : Button
    lateinit var cakegreen : Button
    lateinit var cakestrawch : Button
    lateinit var cakestrawroll : Button
    lateinit var cakestrocream : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank3, container, false)

        cakechoco = view.findViewById<Button>(R.id.cakechoco)
        cakegreen = view.findViewById<Button>(R.id.cakegreen)
        cakestrawch = view.findViewById<Button>(R.id.cakestrawch)
        cakestrawroll = view.findViewById<Button>(R.id.cakestrawroll)
        cakestrocream = view.findViewById<Button>(R.id.cakestrocream)


        //비음료 코드: 30
        cakechoco.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", cakechoco.text.toString())
            intent.putExtra("menuName", "cakechoco")
            intent.putExtra("menuNum", 30)
            startActivityForResult(intent, 0)
        }

        cakegreen.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", cakegreen.text.toString())
            intent.putExtra("menuName", "cakegreen")
            intent.putExtra("menuNum", 30)
            startActivityForResult(intent, 0)
        }

        cakestrawch.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", cakestrawch.text.toString())
            intent.putExtra("menuName", "cakestrawch")
            intent.putExtra("menuNum", 30)
            startActivityForResult(intent, 0)
        }

        cakestrawroll.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", cakestrawroll.text.toString())
            intent.putExtra("menuName", "cakestrawroll")
            intent.putExtra("menuNum", 30)
            startActivityForResult(intent, 0)
        }

        cakestrocream.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", cakestrocream.text.toString())
            intent.putExtra("menuName", "cakestrocream")
            intent.putExtra("menuNum", 30)
            startActivityForResult(intent, 0)
        }
        return view
    }
}