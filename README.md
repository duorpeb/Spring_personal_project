> # 💡 info Hub - 커뮤니티 사이트 (Spring 개인 프로젝트)

<img src="https://capsule-render.vercel.app/api?type=waving&height=300&color=gradient&text=info-Hub">


### 🖥️ 스크린샷

> 📗 메인 페이지 - 실시간 뉴스 기사 10개 출력 (이미지에는 4개만 표시)
>> <img width="1200" height="644" alt="image" src="https://github.com/user-attachments/assets/98f3b39b-8166-4faa-9333-0cf55619aa04" />
<br><br>

> 📗 메인 페이지 - 뉴스 기사 출력 시 이동 페이지 (해당 기사 원문으로 이동)
>> <img width="454" height="570" alt="image" src="https://github.com/user-attachments/assets/74f79eae-4e4d-4068-865a-38e2291b20c4" />
<br><br>

> 📗 메인 페이지 - 이번주 날씨 정보 (현재 날짜부터 4일간의 날씨 정보) 출력
>> <img width="1200" height="327" alt="image" src="https://github.com/user-attachments/assets/a8f92693-b004-4a28-b783-4ee8482f073e" />
<br><br>

> 📗 메인 페이지 - 최신 게시글과 좋아요 · 댓글 · 조회수 많은 순 게시글 출력, 카테고리 별 게시글 조회 및 게시글 작성 
>> <img width="1200" height="735" alt="image" src="https://github.com/user-attachments/assets/c3713d30-d641-46bc-af07-64a8d53ce3ba" />
<br><br>

> 📗 게시글 작성 페이지 - 카테고리 선택하여 게시글 작성
>> <img width="1200" height="600" alt="image" src="https://github.com/user-attachments/assets/93127bd7-6539-42ec-8291-fe448030b24e" />

<br><br>

> 📗 게시글 작성 페이지 - 파일 첨부 (.exe, .jar, .msi, .dll, .sh, .bat 파일은 업로드 불가)
>> <img width="112" height="93" alt="image" src="https://github.com/user-attachments/assets/aec1cc7a-8d8d-43b8-9b9d-00e3e176ab7c" /> <img width="132" height="87" alt="image" src="https://github.com/user-attachments/assets/eaf1fbb8-e0d6-44d6-844f-8d247c5a0d19" />

<br><br>

> 📗 게시글 상세 조회 페이지 - 댓글 작성, 좋아요, 뒤로 가기, 이전글로 이동, 다음글로 이동
>> <img width="1200" height="738" alt="image" src="https://github.com/user-attachments/assets/6daa862a-6116-4afc-9393-806f049cb41f" />
<br><br>

> 📗 로그인 페이지 - 유효성 검사 (밸리데이션)
>> <img width="1200" height="726" alt="image" src="https://github.com/user-attachments/assets/6fa8b4cb-337b-4274-ba37-f051c6dcf012" />
<br><br>

> 📗 회원 가입 페이지 - 아이디 · 닉네임 중복 검사, 유효성 검사 
>> <img width="365" height="530" alt="image" src="https://github.com/user-attachments/assets/560a57a2-74cd-40eb-a0d5-ea1e317843f5" />
<br><br>

> 📗 회원 정보 수정 페이지 - 프로필 사진 · 이메일 · 비밀번호 수정, 회원 탈퇴
>> <img width="501" height="648" alt="image" src="https://github.com/user-attachments/assets/7d153e56-e563-408a-92f8-07805f14ab55" />


<br><br><br><br><br>


> # 💡 프로젝트 소개 
🖥️ 

<br><br><br><br><br>


> # 💡개발 기간 및 팀 규모 
### 🖥️ 개발 기간 
2025/06/12 ~ 2025/06/18 (7일) <br><br>

### 🖥️ 개발 인원 
1명 

<br><br><br><br><br>


> # 💡 기술 스택
### 🖥️ LANGUAGE

<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> <br><br>

### 🖥️ API 
<img src="https://img.shields.io/badge/naver search API-03C75A?style=for-the-badge&logo=naver&logoColor=white"> <img src="https://img.shields.io/badge/기상청_단기예보_API-EB4D6F"> <img src="https://img.shields.io/badge/Geolocation_Web API-42A1F5"> 

### 🖥️ 라이브러리 

   
<br><br><br><br><br>


> # 💡 폴더 구조
```
📁 infoHub/
└─ 📂 myproject/
   ├─ 📂 .settings/
   │  
   ├─ 📂 src/
   │  ├─ 📂 main/
   │  │  ├─ 📂 java/
   │  │  │  └─ 📂 com/
   │  │  │     └─ 📂 myproject/
   │  │  │        └─ 📂 www/
   │  │  │           ├─ 📂 api/
   │  │  │           │  ├─ JacksonConfig.java
   │  │  │           │  ├─ NaverNewsAPIHandler.java
   │  │  │           │  └─ WeatherShortTermAPIHandler.java
   │  │  │           │ 
   │  │  │           ├─ 📂 config/
   │  │  │           │  ├─ RootConfig.java
   │  │  │           │  ├─ SecurityConfig.java
   │  │  │           │  ├─ SecurityInitializer.java
   │  │  │           │  ├─ ServletConfiguration.java
   │  │  │           │  └─ WebConfig.java
   │  │  │           │ 
   │  │  │           ├─ 📂 controller/
   │  │  │           │  ├─ BoardController.java
   │  │  │           │  ├─ CommentController.java
   │  │  │           │  ├─ HomeController.java
   │  │  │           │  ├─ NewsController.java
   │  │  │           │  ├─ UserController.java
   │  │  │           │  └─ WeatherController.java
   │  │  │           │ 
   │  │  │           ├─ 📂 domain/
   │  │  │           │  ├─ AuthVO.java
   │  │  │           │  ├─ BoardDTO.java
   │  │  │           │  ├─ BoardVO.java
   │  │  │           │  ├─ BookmarkVO.java
   │  │  │           │  ├─ CommentVO.java
   │  │  │           │  ├─ FileVO.java
   │  │  │           │  ├─ ItemVO.java
   │  │  │           │  ├─ LikeVO.java
   │  │  │           │  ├─ NewsDTO.java
   │  │  │           │  ├─ PagingVO.java
   │  │  │           │  ├─ UserVO.java
   │  │  │           │  ├─ WeatherBodyDTO.java
   │  │  │           │  ├─ WeatherBodyItemsDTO.java
   │  │  │           │  ├─ WeatherHeaderDTO.java
   │  │  │           │  ├─ WeatherItemVO.java
   │  │  │           │  ├─ WeatherResponse.java
   │  │  │           │  ├─ WeatherResponseDTO.java
   │  │  │           │  ├─ WeatherShortObj.java
   │  │  │           │  └─ WeatherShortObjForJS.java
   │  │  │           │ 
   │  │  │           ├─ 📂 exception/
   │  │  │           │  └─ CommonExceptionAdvice.java
   │  │  │           │ 
   │  │  │           ├─ 📂 handler/
   │  │  │           │  ├─ FileHandler.java
   │  │  │           │  ├─ PagingHandler.java
   │  │  │           │  └─ ProfileImgSweeper.java
   │  │  │           │ 
   │  │  │           ├─ 📂 repository/
   │  │  │           │  ├─ BoardDAO.java
   │  │  │           │  ├─ BookmarkDAO.java
   │  │  │           │  ├─ CommentDAO.java
   │  │  │           │  ├─ FileDAO.java
   │  │  │           │  ├─ LikeDAO.java
   │  │  │           │  └─ UserDAO.java
   │  │  │           │ 
   │  │  │           ├─ 📂 security/
   │  │  │           │  ├─ AuthUser.java
   │  │  │           │  ├─ CustomAuthUserService.java
   │  │  │           │  ├─ LoginFailureHandler.java
   │  │  │           │  └─ LoginSuccessHandler.java
   │  │  │           │ 
   │  │  │           └─ 📂 service/
   │  │  │              ├─ BoardService.java
   │  │  │              ├─ BoardServiceImpl.java
   │  │  │              ├─ BookmarkService.java
   │  │  │              ├─ BookmarkServiceImpl.java
   │  │  │              ├─ CommentService.java
   │  │  │              ├─ CommentServiceImpl.java
   │  │  │              ├─ UserService.java
   │  │  │              └─ UserServiceImpl.java
   │  │  │     
   │  │  ├─ 📂 resources/
   │  │  │  ├─ 📂 META-INF/
   │  │  │  │
   │  │  │  ├─ 📂 mapper/
   │  │  │  │  ├─ boardMapper.xml
   │  │  │  │  ├─ commentMapper.xml
   │  │  │  │  ├─ fileMapper.xml
   │  │  │  │  ├─ likeMapper.xml
   │  │  │  │  └─ userMapper.xml
   │  │  │  │
   │  │  │  ├─ log4j.xml
   │  │  │  ├─ log4jdbc.log4j2.properties
   │  │  │  ├─ logback.xml
   │  │  │  ├─ mybatisConfig.xml
   │  │  │  └─ sql.txt
   │  │  │  
   │  │  └─ 📂 webapp/
   │  │     ├─ 📂 WEB-INF/
   │  │     │  ├─ 📂 classes/
   │  │     │  │
   │  │     │  ├─ 📂 spring/
   │  │     │  │  ├─ appServlet/
   │  │     │  │  │  └─ servlet-context.xml
   │  │     │  │  └─ root-context.xml
   │  │     │  │
   │  │     │  └─ 📂 views/
   │  │     │     ├─ 📂 board/
   │  │     │     │  ├─ detail.jsp
   │  │     │     │  ├─ list.jsp
   │  │     │     │  ├─ modify.jsp
   │  │     │     │  └─ register.jsp
   │  │     │     ├─ 📂 layout/
   │  │     │     │  ├─ footer.jsp
   │  │     │     │  ├─ header.jsp
   │  │     │     │  └─ layoutSample.jsp
   │  │     │     │ 
   │  │     │     ├─ 📂 user/
   │  │     │     │  ├─ join.jsp
   │  │     │     │  ├─ login.jsp
   │  │     │     │  └─ mypage.jsp
   │  │     │     └─ home.jsp
   │  │     │     
   │  │     └─ 📂 resources/
   │  │        ├─ 📂 img/
   │  │        │  ├─ bootstrap-5.3.6-dist.zip
   │  │        │  ├─ default-avatar.png
   │  │        │  ├─ loginBackImg.png
   │  │        │  ├─ logo.png
   │  │        │  ├─ weather-cloudy-and-rain.png
   │  │        │  ├─ weather-cloudy.png
   │  │        │  ├─ weather-icon.png
   │  │        │  ├─ weather-rain.png
   │  │        │  ├─ weather-snow.png
   │  │        │  ├─ weather-sunny.png
   │  │        │  └─ weather-thunder-and-rain.png
   │  │        │
   │  │        └─ 📂 js/
   │  │           ├─ ShortTermForecastToJsonInKor.js
   │  │           ├─ WeatherOpenAPIAppendixDoc.js
   │  │           ├─ boardDetail.js
   │  │           ├─ boardModify.js
   │  │           ├─ boardRegisterFile.js
   │  │           ├─ duplicatedNickCheck.js
   │  │           ├─ geolocationAndWeatherAPI.js
   │  │           ├─ home.js
   │  │           ├─ imgCheck.js
   │  │           ├─ imgPreview.js
   │  │           ├─ logout.js
   │  │           ├─ package-lock.json
   │  │           ├─ package.json
   │  │           └─ 기상청41_단기예보 조회서비스_오픈API활용가이드_격자_위경도(2411).xlsx
   │  │
   │  └─ 📂 test/
   │     ├─ 📂 java/
   │     │  └─ 📂 com/
   │     │     └─ 📂 myproject/
   │     │        └─ 📂 www/
   │     │ 
   │     └─ 📂 resources/
   │        └─ log4j.xml
   │   
   ├─ .classpath
   ├─ .project
   ├─ .springBeans
   ├─ README.md
   └─ pom.xml
```
<br><br><br><br><br>


> # 💡기능




<br><br><br><br><br>


> # 💡 프로젝트 소감
 

