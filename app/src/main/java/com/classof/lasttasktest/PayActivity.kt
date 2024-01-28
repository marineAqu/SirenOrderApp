package com.classof.lasttasktest

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class PayActivity : AppCompatActivity() {
    lateinit var shopNameTv : TextView
    lateinit var menuListTv : TextView
    lateinit var orderTypeTv : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)

        title = "결제 완료"
        shopNameTv = findViewById<TextView>(R.id.shopNameTv)
        menuListTv = findViewById<TextView>(R.id.menuListTv)
        orderTypeTv = findViewById<TextView>(R.id.orderTypeTv)

        var intent = intent
        var selectMenuList = intent.getStringArrayExtra("selectMenuList")
        var shopName = intent.getStringExtra("shopName")
        var orderType = intent.getStringExtra("orderType")
        var totPrice = intent.getIntExtra("totPrice", 0)
        var menuLis = ""
        for(i in 0..selectMenuList!!.indexOfFirst { it == "" }) menuLis = menuLis.plus(selectMenuList[i]).plus("\n\n")


        //총금액 팝업 띄우고 결제
        var dlg = AlertDialog.Builder(this@PayActivity)
        dlg.setTitle("결제")
        dlg.setMessage(totPrice.toString() + "원 결제하시겠습니까?")
        dlg.setPositiveButton("신용카드 결제", null)
        dlg.setNegativeButton("카카오페이 결제", null)
        dlg.setCancelable(false)    //뒤로가기나 다이어로그 밖 화면 등 터치 시의 캔슬을 막음
        dlg.show()

        //메뉴(가격없이)만 띄우고 결제 완료 창
        shopNameTv.setText("고객님께서\n"+shopName.toString()+" 지점에서 주문하신\n")
        menuListTv.setText(menuLis)
        orderTypeTv.setText("\n"+orderType.toString()+" 주문이 성공적으로 결제되었습니다.\n이용해주셔서 감사합니다.")
    }
}