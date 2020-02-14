# project process

1. 프로젝트 주제선정

   - 멀티캠퍼스 20층 식당: 식권관리 및 리뷰 페이지

2. 프로젝트 주제에 따른 기능 선정(crud기능 중심)

   - 로그인-아이디,비번,
   - 회원가입- 아이디,비번, 이름, 클래스넘버
   - 게시판
     - 게시판1: 식단리뷰-crud,사진,페이징
     - 게시판2: 건의게시판 -crud,사진,페이징
     - 게시판3: 외부식당리뷰-crud,사진,페이징
     - 관리자게시판: 오늘의메뉴-관리자권한, crud,사진
   - 메인페이지
     - 식권구입: 포인트--, 식권++
     - 사용: 식권--, 가짜 바코드, 이용횟수++
     - 포인트충전: 포인트++, 몇포인트충전할지 선택(1000원=10p)

3. 프로젝트 기능에 따른 DB설계

   ![db](images\db.png)

   * class,  mcreviewboard, reviewboard, sugboard, users
   * 추가예정
     * menuboard

4. 프로젝트 기능에 따른 화면설계

   게시판

   - 게시판1: 식단리뷰-**insertform**(create),**detail**(read, delete,update),**list** `jsp`
   - 게시판2: 건의게시판 --**insertform**(create),**detail**(read, delete,update),**list** `jsp`
   - 게시판3: 외부식당리뷰--**insertform**(create),**detail**(read, delete,update),**list** `jsp`
   - 관리자게시판: 오늘의메뉴-관리자권한, crud,사진

5. 조원별 역할 분담

   - 각 조원끼리 패키지명, 클래스명, 변수명, 파일경로, DB테이블명, 컬럼명 등 약속&공유
     - 로그인-유미선
     - 회원가입-?
     - 게시판1: 식단리뷰-정혜진
     - 게시판2: 건의게시판-최혜근
     - 게시판3: 외부식당리뷰-이효진
     - 관리자게시판: 오늘의메뉴
     - 메인페이지: 식권구입, 사용, 포인트충전

6. 각 조원별 분담한 역할대로 **구현**

   * 한 조원이 1개의 기능 담당(모든 기능)

     DB설계-화면설계-MVC구현 등 모두 해볼 수 있도록 구성

7. 각 조원들 프로젝트 **통합**
8. 발표시연
   
   - 프로젝트 산출물: 스프링프로젝트+ppt



## URL

* 기본주소  :  ~~/multifood

* 게시판 : /multifood/(((review))
  `/boardlist`

  `/boardinsert`

  `/boarddetail`

  `/boardupdate`

  `/boarddelete`

