package com.classof.lasttasktest

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext

class MainActivity : AppCompatActivity() {
    lateinit var shopBtn: Button
    lateinit var TakeOutBtn: Button
    lateinit var ShopSpinner : Spinner

    var shopName = arrayOf("매장을 선택하세요", "안드로이드카페 수원대점",
        "안드로이드카페 병점역점", "안드로이드카페 안양역점")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "안드로이드 cafe"

        //광고 팝업 띄우기
        var iv = ImageView(applicationContext)
        iv.setImageResource(R.drawable.adimg)
        var dlg = AlertDialog.Builder(this@MainActivity)
        dlg.setView(iv)
        dlg.setPositiveButton("닫기", null)
        dlg.show()


        ShopSpinner = findViewById<Spinner>(R.id.ShopSpinner)
        var adapter: ArrayAdapter<String>
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, shopName)
        ShopSpinner.adapter = adapter

        shopBtn = findViewById<Button>(R.id.shopBtn)
        TakeOutBtn = findViewById<Button>(R.id.TakeOutBtn)

        //매장일 때
        shopBtn.setOnClickListener {
            //매장을 아직 선택하지 않았으면 다음 화면으로 넘어가지 않는다.
            if(ShopSpinner.selectedItem == "매장을 선택하세요") {
                Toast.makeText(this, "매장을 선택해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var intent = Intent(applicationContext, SelectmenuActivity::class.java)
            intent.putExtra("shopName", ShopSpinner.selectedItem.toString())
            intent.putExtra("orderType", "매장 이용")
            startActivity(intent)
        }

        //테이크 아웃일 때
        TakeOutBtn.setOnClickListener{
            //매장을 아직 선택하지 않았으면 다음 화면으로 넘어가지 않는다.
            if(ShopSpinner.selectedItem == "매장을 선택하세요") {
                Toast.makeText(this, "매장을 선택해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var intent = Intent(applicationContext, SelectmenuActivity::class.java)
            intent.putExtra("shopName", ShopSpinner.selectedItem.toString())
            intent.putExtra("orderType", "테이크아웃")
            startActivity(intent)
        }
    }
}