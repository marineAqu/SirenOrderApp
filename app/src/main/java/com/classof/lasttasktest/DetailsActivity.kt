package com.classof.lasttasktest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class DetailsActivity  : AppCompatActivity() {

    lateinit var menuImage : ImageView
    lateinit var MenuDesc : TextView
    lateinit var iceRGroup : RadioGroup
    lateinit var hotBtn : RadioButton
    lateinit var iceBtn : RadioButton
    lateinit var sizeRGroup : RadioGroup
    lateinit var tallBtn : RadioButton
    lateinit var GrandeBtn : RadioButton
    lateinit var ventiBtn : RadioButton
    lateinit var decafLayout : LinearLayout
    lateinit var ShotLayout : LinearLayout
    lateinit var syrupOptions : TextView
    lateinit var vanillaSyrup : CheckBox
    lateinit var HazelnutSyrup : CheckBox
    lateinit var CaramelSyrup : CheckBox
    lateinit var shotMinBtn : Button
    lateinit var shotAddBtn : Button
    lateinit var shotNum : TextView
    lateinit var decafCheck : CheckBox
    lateinit var FinishBtn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_of_menu)

        title = "상세 주문"

        //intent 받기
        var intent = intent
        var menuDescPre = intent.getStringExtra("menuDesc")
        var menuName = intent.getStringExtra("menuName")
        var menuNum = intent.getIntExtra("menuNum", 0)

        //메뉴 설명 TextView과 메뉴 옵션 정보String에 넣을 메뉴 한글 이름 넣기
        if(menuDescPre.isNullOrEmpty()) menuDescPre = "오류 발생"
        var menuKoName = menuDescPre.substring(0, menuDescPre.indexOf('\n'))
        
        //옵션에 따른 가격 변화 변수
        var OrderPrice = menuDescPre.substring(menuDescPre.indexOf('\n')+2, menuDescPre.indexOf('\n')+6).toInt()

        //다음 레이아웃에 주문 상세 정보를 넘길 변수. 한글 메뉴 이름으로 초기화한다
        var OrderDetail : String? = menuKoName.plus("\n")



        menuImage = findViewById<ImageView>(R.id.menuImage)
        MenuDesc = findViewById<TextView>(R.id.MenuDesc)
        iceRGroup = findViewById<RadioGroup>(R.id.iceRGroup)
        hotBtn = findViewById<RadioButton>(R.id.hotBtn)
        iceBtn = findViewById<RadioButton>(R.id.iceBtn)
        sizeRGroup = findViewById<RadioGroup>(R.id.sizeRGroup)
        tallBtn = findViewById<RadioButton>(R.id.tallBtn)
        GrandeBtn = findViewById<RadioButton>(R.id.grandeBtn)
        ventiBtn = findViewById<RadioButton>(R.id.ventiBtn)
        decafLayout = findViewById<LinearLayout>(R.id.decafLayout)
        ShotLayout = findViewById<LinearLayout>(R.id.ShotLayout)
        decafCheck = findViewById<CheckBox>(R.id.decafCheck)
        syrupOptions = findViewById<TextView>(R.id.syrupOptions)
        vanillaSyrup = findViewById<CheckBox>(R.id.vanillaSyrup)
        HazelnutSyrup = findViewById<CheckBox>(R.id.HazelnutSyrup)
        CaramelSyrup = findViewById<CheckBox>(R.id.CaramelSyrup)
        shotMinBtn = findViewById<Button>(R.id.shotMinBtn)
        shotAddBtn = findViewById<Button>(R.id.shotAddBtn)
        shotNum = findViewById<TextView>(R.id.shotNum)
        FinishBtn = findViewById<Button>(R.id.FinishBtn)

        //설명 문구 설정
        MenuDesc.setText(menuKoName)

        //이미지 설정
        val resourceId = resources.getIdentifier(menuName, "drawable", packageName)
        if (resourceId != 0) {
            menuImage.setImageResource(resourceId)
        }


        when(menuNum){
            //커피메뉴 코드: 커피 메뉴에 해당할 경우 디카페인, 샷, 시럽을 설정할 수 있다
            1 -> {
                decafLayout.visibility = android.view.View.VISIBLE
                ShotLayout.visibility = android.view.View.VISIBLE
                syrupOptions.visibility = android.view.View.VISIBLE
            }
            //티 코드: 티에 해당할 경우 핫만 선택할 수 있다.
            5 -> {
                iceBtn.visibility = android.view.View.GONE
                hotBtn.isChecked = true
                hotBtn.setText("핫만 선택할 수 있는 메뉴입니다.")
            }
            //에이드, 셰이크 코드: 클릭 못하게 막고 클릭 시 "해당 메뉴는 핫을 선택할 수 없습니다"띄우기
            7 -> {
                hotBtn.visibility = android.view.View.GONE
                iceBtn.isChecked = true
                iceBtn.setText("아이스만 선택할 수 있는 메뉴입니다.")
            }

            //비음료 코드: ice설정과 사이즈 설정 할 수 없다
            30 -> {
                iceRGroup.visibility = android.view.View.INVISIBLE
                sizeRGroup.visibility = android.view.View.INVISIBLE
            }
        }

        //샷 빼기 버튼
        shotMinBtn.setOnClickListener{
            if(shotNum.text.toString().toInt() == 1) Toast.makeText(this, "해당 메뉴는 샷을 1 이상으로 설정해야 합니다.", Toast.LENGTH_SHORT).show()
            else shotNum.setText((shotNum.text.toString().toInt() - 1).toString())
        }

        //샷 더하기 버튼
        shotAddBtn.setOnClickListener{
            shotNum.setText((shotNum.text.toString().toInt() + 1).toString())
        }

        //시럽 보이기, 닫기
        syrupOptions.setOnClickListener{
            if(vanillaSyrup.isVisible){
                syrupOptions.text="시럽 추가 ▽"
                vanillaSyrup.visibility = android.view.View.INVISIBLE
                HazelnutSyrup.visibility = android.view.View.INVISIBLE
                CaramelSyrup.visibility = android.view.View.INVISIBLE
            }
            else{
                syrupOptions.text="시럽 추가 △"
                vanillaSyrup.visibility = android.view.View.VISIBLE
                HazelnutSyrup.visibility = android.view.View.VISIBLE
                CaramelSyrup.visibility = android.view.View.VISIBLE
            }
        }

        //옵션 선택 완료 후 결제
        FinishBtn.setOnClickListener{
            // 핫/아이스
            when(menuNum){
                in 1..7 -> {
                    when (iceRGroup.checkedRadioButtonId){
                        R.id.hotBtn -> OrderDetail = OrderDetail.plus("hot ")
                        R.id.iceBtn -> OrderDetail = OrderDetail.plus("ice ")

                        else -> {
                            Toast.makeText(applicationContext, "핫/아이스를 선택해주세요.", Toast.LENGTH_SHORT).show()
                            return@setOnClickListener
                        }
                    }

                    // 사이즈
                    when (sizeRGroup.checkedRadioButtonId){
                        R.id.tallBtn -> OrderDetail = OrderDetail.plus("| tall ")
                        R.id.grandeBtn -> {
                            OrderDetail = OrderDetail.plus("| grande ")
                            OrderPrice = OrderPrice + 500
                        }
                        R.id.ventiBtn -> {
                            OrderDetail = OrderDetail.plus("| venti ")
                            OrderPrice = OrderPrice + 1000
                        }

                        else -> {
                            Toast.makeText(applicationContext, "사이즈를 선택해주세요.", Toast.LENGTH_SHORT).show()
                            return@setOnClickListener
                        }
                    }
                }
            }


            //커피 메뉴에 해당할 경우
            when(menuNum){
                1 -> {
                    //디카페인 체크 여부
                    if(decafCheck.isChecked == true) {
                        OrderDetail = OrderDetail.plus("| 디카페인 ")
                        OrderPrice = OrderPrice + 300
                    }
                    else {
                        OrderDetail = OrderDetail.plus("| - ")
                    }

                    //샷
                    OrderDetail = OrderDetail.plus("| "+shotNum.text.toString()+"샷 ")
                    OrderPrice = OrderPrice + (600 * (shotNum.text.toString().toInt()-1))

                    //시럽
                    if(vanillaSyrup.isChecked == true) {
                        OrderDetail = OrderDetail.plus("| 바닐라 시럽 추가")
                        OrderPrice = OrderPrice + 600
                    }
                    if(HazelnutSyrup.isChecked == true) {
                        OrderDetail = OrderDetail.plus("| 헤이즐넛 시럽 추가")
                        OrderPrice = OrderPrice + 600
                    }
                    if(CaramelSyrup.isChecked == true) {
                        OrderDetail = OrderDetail.plus("| 카라멜 시럽 추가")
                        OrderPrice = OrderPrice + 600
                    }
                }
                1 -> {
                    OrderDetail = OrderDetail.plus("\n")
                }
            }

            //다시 selectActivity로 돌아간다.
            var outIntent = Intent(applicationContext, SelectmenuActivity::class.java)
            outIntent.putExtra("OrderDetail",OrderDetail)
            outIntent.putExtra("OrderPrice", OrderPrice)

            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }



    }
}