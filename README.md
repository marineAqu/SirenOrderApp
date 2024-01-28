# 안드로이드 카페 어플리케이션

> 백앤드: Kotlin

> 개발 기간: 2023. 5. 13. ~ 2023. 6. 3. (3주)

> 1인 개발


## 1. App 개발 목적과 효용성

이 어플리케이션은 프랜차이즈 카페에서 모바일 주문이 가능한 어플리케이션을 개발하는 목적으로 제작되었습니다. 현업에서 사용되는 모바일 오더 기능과 비교하여 대다수의 기능을 구현하여 효용성을 갖추고 있습니다.

## 2. 전체 App 에 대한 기본 설명

- `logo.xml`: 어플리케이션 로고를 띄우는 스플래시 화면
- `activity_main.xml`: 매장 선택 및 주문 시작을 위한 화면
- `selectmenu.xml` / `fragment_blank1.xml` / `fragment_blank2.xml` / `fragment_blank3.xml`: 주문할 메뉴 선택을 위한 화면 및 탭 구현
- `details_of_menu.xml`: 각 메뉴의 세부 옵션 선택을 위한 화면
- `checkorder.xml`: 주문 내역 확인 및 수정을 위한 화면
- `activity_pay.xml`: 결제 화면

## 3. image 사용시 데이터 저장 구조

앱에서 사용되는 이미지들은 `@drawable` 폴더에 저장

## 4. 각 화면별 작동 설명

- `logo.xml`: 어플리케이션 로고를 보여주는 스플래시 화면
- `activity_main.xml`: 매장 선택 및 광고 팝업을 통한 주문 시작 화면
- `selectmenu.xml` / `fragment_blank1.xml` / `fragment_blank2.xml` / `fragment_blank3.xml`: 메뉴 선택 및 주문화면
- `details_of_menu.xml`: 각 메뉴의 세부 옵션 선택 화면
- `checkorder.xml`: 주문 내역 확인 및 수정 화면
- `activity_pay.xml`: 결제 화면

## 5. 기타

- 최대 주문 가능 메뉴 개수는 40개로 설정되었으며, 이에 따라 효율적인 코드 구현을 위해 코틀린 코드를 활용하였습니다.
- 이미지 사용 및 디자인에 관한 고민과 구현 방법을 상세히 기술하였습니다
- 주문 내역 화면에서 X 버튼을 통한 동적인 테이블 로우 제거에 대한 설명이 포함되어 있습니다
