package com.classof.lasttasktest

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.widget.Adapter
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class SelectmenuActivity : AppCompatActivity() {
    lateinit var menutab : TabLayout
    lateinit var menuVP : ViewPager2
    lateinit var orderBtn :Button
    
    //onCreate 위에 정의. 메뉴 리스트와 가격 리스트와 선택 개수
    var selectMenuList: Array<String> = Array(40) { "" }
    var selectMenuPrice = IntArray(40)
    var checkLasIn = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.selectmenu)

        title = "안드로이드 cafe"

        var intent = intent
        var OrderDetail = intent.getStringExtra("OrderDetail")

        var shopName = intent.getStringExtra("shopName")
        var orderType = intent.getStringExtra("orderType")

        //checkOrderActivity에서 돌아왔다면
        checkLasIn = intent.getIntExtra("checkLasIn", -1)
        if(checkLasIn>-1){
            selectMenuList = intent.getStringArrayExtra("selectMenuList")!!
            selectMenuPrice = intent.getIntArrayExtra("selectMenuPrice")!!
        }



        menutab = findViewById<TabLayout>(R.id.menutab)
        menuVP = findViewById<ViewPager2>(R.id.menuVP)
        orderBtn = findViewById<Button>(R.id.orderBtn)

        orderBtn.setText((checkLasIn+1).toString()+"개 주문하기")

        //최종 주문 버튼
        orderBtn.setOnClickListener{
            //아무것도 선택하지 않고 "주문하기"버튼을 누를 시
            if(selectMenuList.indexOfFirst { it == "" } == 0){
                Toast.makeText(this, "주문할 메뉴를 골라주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var intent = Intent(applicationContext, CheckOrderActivity::class.java)
            intent.putExtra("selectMenuList", selectMenuList)
            intent.putExtra("selectMenuPrice", selectMenuPrice)
            intent.putExtra("checkLasIn", checkLasIn)
            intent.putExtra("orderType", orderType)
            intent.putExtra("shopName", shopName)
            startActivity(intent)
            finish()
        }


        menutab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // 탭이 선택 되었을 때
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // 탭이 선택되지 않은 상태로 변경 되었을 때
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // 이미 선택된 탭이 다시 선택 되었을 때
            }
        })
        // 뷰페이저에 어댑터 연결
        menuVP.adapter = VPAdapter(this)

        //탭과 뷰페이저를 연결
        TabLayoutMediator(menutab, menuVP) {tab, position ->
            when(position) {
                0 -> tab.text = "음료"
                1 -> tab.text = "베이커리"
                2 -> tab.text = "케이크"
            }
        }.attach()
    }

    //디테일 activity에서 돌아온 경우
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            var OrderDetail = data!!.getStringExtra("OrderDetail")
            var OrderPrice = data!!.getIntExtra("OrderPrice", 0)

            if(OrderDetail.isNullOrEmpty()) OrderDetail = "오류 발생"

            //선택한 항목의 개수를 찾아보는 변수
            checkLasIn = selectMenuList.indexOfFirst { it == "" }
            selectMenuList[checkLasIn]= OrderDetail
            selectMenuPrice[checkLasIn] = OrderPrice

            //장바구니에 담은 항목 보여주기
            orderBtn.setText((checkLasIn+1).toString()+"개 주문하기")
        }
    }
}