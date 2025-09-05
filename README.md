> # 💡 info Hub - 커뮤니티 사이트 (Spring 개인 프로젝트)

<img src="https://capsule-render.vercel.app/api?type=waving&height=300&color=gradient&text=info-Hub">


### 🖥️ 스크린샷


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

<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> <br><br>

### 🖥️ API 


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
 

