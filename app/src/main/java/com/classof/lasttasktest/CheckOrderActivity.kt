package com.classof.lasttasktest

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class CheckOrderActivity : AppCompatActivity() {

    lateinit var totPriceTv : TextView
    lateinit var backBtn : Button
    lateinit var payBtn : Button
    lateinit var TabLay : TableLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkorder)

        title = "주문 확인"

        var intent = intent
        var selectMenuList = intent.getStringArrayExtra("selectMenuList")
        var selectMenuPrice = intent.getIntArrayExtra("selectMenuPrice")
        var checkLasIn = intent.getIntExtra("checkLasIn", 0)
        var shopName = intent.getStringExtra("shopName")
        var orderType = intent.getStringExtra("orderType")


        var totPrice = 0
        for (i in 0..checkLasIn) totPrice += selectMenuPrice!![i]

        totPriceTv = findViewById<TextView>(R.id.totPriceTv)

        backBtn = findViewById<Button>(R.id.backBtn)
        payBtn = findViewById<Button>(R.id.payBtn)
        TabLay = findViewById<TableLayout>(R.id.TabLay)
        totPriceTv.setText("총 금액: " + totPrice.toString()+"원")

        fun clickdelBtn(i: Int){
            // i보다 큰 인덱스의 요소를 앞당기는 작업
            for (index in i+1 until selectMenuList!!.size) {
                selectMenuList[index-1] = selectMenuList[index]
                selectMenuPrice!![index-1] = selectMenuPrice[index]
            }

            // 마지막 인덱스의 요소 초기화
            selectMenuList[selectMenuList.size-1] = ""
            selectMenuPrice!![selectMenuPrice.size-1] = 0

            //인덱스 하나 빼기
            checkLasIn -= 1
        }

        //메뉴가 하나 이상일 경우 추가한다.
        for (i in 0 .. checkLasIn) {
            val tableRow = TableRow(this)
            tableRow.id = View.generateViewId()
            //tableRow.id = "tabR".plus(i.toString()).toInt()

            val textView = TextView(this)
            textView.id = View.generateViewId()
            textView.layoutParams = TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                260,
                1f
            )
            textView.setText(selectMenuList?.getOrNull(i)+"\n"+selectMenuPrice?.getOrNull(i))
            textView.setTextColor(ContextCompat.getColor(this, R.color.black))
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16f)
            val button = Button(this)
            button.id = View.generateViewId()
            button.layoutParams = TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT
            )
            button.setBackgroundResource(R.color.blueTheme)
            button.setTextColor(getResources().getColor(R.color.white))
            button.text = "x"
            button.setOnClickListener{
                clickdelBtn(i)

                tableRow.visibility = android.view.View.GONE
                totPrice = 0
                for (i in 0..checkLasIn) totPrice += selectMenuPrice!![i]
                totPriceTv.setText("총 금액: " + totPrice.toString()+"원")
            }

            tableRow.addView(textView)
            tableRow.addView(button)

            TabLay.addView(tableRow)
        }


        //추가하기 버튼
        backBtn.setOnClickListener{
            var outIntent = Intent(applicationContext, SelectmenuActivity::class.java)
            outIntent.putExtra("selectMenuList",selectMenuList)
            outIntent.putExtra("selectMenuPrice", selectMenuPrice)
            outIntent.putExtra("checkLasIn", checkLasIn)
            outIntent.putExtra("orderType", orderType)
            outIntent.putExtra("shopName", shopName)
            startActivity(outIntent)
            finish()
        }

        //결제하기 버튼
        payBtn.setOnClickListener{
            if(checkLasIn == -1){
                Toast.makeText(this, "주문할 메뉴를 추가해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var nextintent = Intent(applicationContext, PayActivity::class.java)
            nextintent.putExtra("selectMenuList",selectMenuList)
            nextintent.putExtra("totPrice", totPrice)
            nextintent.putExtra("orderType", orderType)
            nextintent.putExtra("shopName", shopName)
            startActivity(nextintent)
            finish()
        }
    }
}