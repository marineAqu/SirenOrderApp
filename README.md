# 안드로이드 카페 어플리케이션

> 백앤드: Kotlin

> 개발 기간: 2023. 5. 13. ~ 2023. 6. 3. (3주)

> 1인 개발


## 1. 요구사항

- 프랜차이즈 카페에서 모바일 주문이 가능한 어플리케이션 개발 목적으로 제작
- 40개 이상의 메뉴 주문 시 발생할 수 있는 문제를 해결하기 위해 XML 및 Kotlin 코드를 사용하여 동적으로 메뉴를 생성
- `recreate()` 대신 중간에 빠진 인덱스를 조절하여 화면을 깜빡이지 않고 갱신
- 음료와 비음료 메뉴에 따라 필요한 옵션을 동적으로 분류하여 각 메뉴에 따른 옵션 선택 가능 여부를 구현

## 2. 전체 App 에 대한 기본 설명

- `logo.xml`: 어플리케이션 로고를 띄우는 스플래시 화면
- `activity_main.xml`: 매장 선택 및 주문 시작을 위한 화면
- `selectmenu.xml` / `fragment_blank1.xml` / `fragment_blank2.xml` / `fragment_blank3.xml`: 주문할 메뉴 선택을 위한 화면 및 탭 구현
- `details_of_menu.xml`: 각 메뉴의 세부 옵션 선택을 위한 화면
- `checkorder.xml`: 주문 내역 확인 및 수정을 위한 화면
- `activity_pay.xml`: 결제 화면


## 3. 영상
https://github.com/marineAqu/SirenOrderApp/assets/102001809/53e41d6c-e37b-43fa-a576-d880107b8660

