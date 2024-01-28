package com.classof.lasttasktest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class BlankFragment1 : Fragment() {

    lateinit var espresso : Button
    lateinit var americano : Button
    lateinit var cafelatte : Button
    lateinit var caramel : Button
    lateinit var cafemoka : Button
    lateinit var cappuccino : Button
    lateinit var chocolatte : Button
    lateinit var strawlatte : Button
    lateinit var rainbowade : Button
    lateinit var lemonade : Button
    lateinit var limeade : Button
    lateinit var strawsmoothie : Button
    lateinit var chobasmooth : Button
    lateinit var lemontea : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank1, container, false)
        espresso = view.findViewById<Button>(R.id.espresso)
        americano = view.findViewById<Button>(R.id.americano)
        cafelatte = view.findViewById<Button>(R.id.cafelatte)
        caramel = view.findViewById<Button>(R.id.caramel)
        cafemoka = view.findViewById<Button>(R.id.cafemoka)
        cappuccino = view.findViewById<Button>(R.id.cappuccino)
        chocolatte = view.findViewById<Button>(R.id.chocolatte)
        strawlatte = view.findViewById<Button>(R.id.strawlatte)
        rainbowade = view.findViewById<Button>(R.id.rainbowade)
        lemonade = view.findViewById<Button>(R.id.lemonade)
        limeade = view.findViewById<Button>(R.id.limeade)
        strawsmoothie = view.findViewById<Button>(R.id.strawsmoothie)
        chobasmooth = view.findViewById<Button>(R.id.chobasmooth)
        lemontea = view.findViewById<Button>(R.id.lemontea)

        //기본: 아이스핫, 사이즈 설정
        //커피 코드(+샷, 논카페인, 시럽 옵션 설정 가능): 1
        //티 코드(-아이스핫 설정 불가: 무조건 핫): 5
        //스무디와 에이드 코드(-아이스핫 설정 불가: 무조건 아이스): 20
        //비음료 코드(-모든 옵션 설정 불가): 30
        //디폴트 코드: 2
        espresso.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", espresso.text.toString())
            intent.putExtra("menuName", "espresso")
            intent.putExtra("menuNum", 1)
            startActivityForResult(intent, 0)
        }
        americano.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", americano.text.toString())
            intent.putExtra("menuName", "americano")
            intent.putExtra("menuNum", 1)
            startActivityForResult(intent, 0)
        }
        cafelatte.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", cafelatte.text.toString())
            intent.putExtra("menuName", "cafelatte")
            intent.putExtra("menuNum", 1)
            startActivityForResult(intent, 0)
        }
        caramel.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", caramel.text.toString())
            intent.putExtra("menuName", "caramel")
            intent.putExtra("menuNum", 1)
            startActivityForResult(intent, 0)
        }
        cafemoka.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", cafemoka.text.toString())
            intent.putExtra("menuName", "cafemoka")
            intent.putExtra("menuNum", 1)
            startActivityForResult(intent, 0)
        }
        cappuccino.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", cappuccino.text.toString())
            intent.putExtra("menuName", "cappuccino")
            intent.putExtra("menuNum", 1)
            startActivityForResult(intent, 0)
        }
        chocolatte.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", chocolatte.text.toString())
            intent.putExtra("menuName", "chocolatte")
            intent.putExtra("menuNum", 2)
            startActivityForResult(intent, 0)
        }
        strawlatte.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", strawlatte.text.toString())
            intent.putExtra("menuName", "strawlatte")
            intent.putExtra("menuNum", 2)
            startActivityForResult(intent, 0)
        }
        rainbowade.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", rainbowade.text.toString())
            intent.putExtra("menuName", "rainbowade")
            intent.putExtra("menuNum", 7)
            startActivityForResult(intent, 0)
        }
        lemonade.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", lemonade.text.toString())
            intent.putExtra("menuName", "lemonade")
            intent.putExtra("menuNum", 7)
            startActivityForResult(intent, 0)
        }
        limeade.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", limeade.text.toString())
            intent.putExtra("menuName", "limeade")
            intent.putExtra("menuNum", 7)
            startActivityForResult(intent, 0)
        }
        strawsmoothie.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", strawsmoothie.text.toString())
            intent.putExtra("menuName", "strawsmoothie")
            intent.putExtra("menuNum", 7)
            startActivityForResult(intent, 0)
        }
        chobasmooth.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", chobasmooth.text.toString())
            intent.putExtra("menuName", "chobasmooth")
            intent.putExtra("menuNum", 7)
            startActivityForResult(intent, 0)
        }
        lemontea.setOnClickListener{
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("menuDesc", lemontea.text.toString())
            intent.putExtra("menuName", "lemontea")
            intent.putExtra("menuNum", 5)
            startActivityForResult(intent, 0)
        }
        return view
    }
}