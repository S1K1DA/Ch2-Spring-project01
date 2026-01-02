> # CH3 일정 관리 앱 만들기 과제

### 스파르타 내일배움캠프 Spring 백엔드 2기
### 3조 정은식

---

> ## 요약

**일정 관리 앱**

`필수` [STEP 1] : 일정 생성
`필수` [STEP 2] : 일정 조회
`필수` [STEP 3] : 일정 수정
`필수` [STEP 4] : 일정 삭제
`선택` [STEP 5] : 댓글 생성기
`선택` [STEP 6] : 일정 단건 조회 업그레이드
`선택` [STEP 7] : 유저의 입력에 대한 검증 수행


---

> ## 프로젝트 구조

<img width="250" height="600" alt="image" src="https://github.com/user-attachments/assets/d8150128-2ee9-4869-bb89-a358e4fc1a15" />


---

> ## ✅ 필수 기능

### STEP 1. 일정 생성

* 일정 제목, 일정 내용, 작성자명, 비밀번호 입력을 통해 일정 생성
* 일정 고유 ID 자동 생성
* `작성일(createdAt)`, `수정일(modifiedAt)`은 **JPA Auditing**으로 자동 관리
* 최초 생성 시 `수정일 = 작성일`
* API 응답에서 **비밀번호 제외**
<img width="2472" height="1055" alt="image" src="https://github.com/user-attachments/assets/fce915b9-0eb7-4bfc-acdb-eafc94882a65" />
<img width="1963" height="262" alt="image" src="https://github.com/user-attachments/assets/96140187-998e-4795-8098-b4b1c33b2a4a" />

---

### STEP 2. 일정 조회

* 전체 일정 조회 가능
* 등록된 모든 일정 조회
* `수정일 기준 내림차순` 정렬
* API 응답에서 **비밀번호 제외**
* 작성자 기준 일정 조회 (`Query Parameter` 활용)
<img width="2411" height="1365" alt="image" src="https://github.com/user-attachments/assets/3d3e16b5-0ecb-4793-b39c-13fd55cd8ccf" />

---

### STEP 3. 일정 수정

* 일정 ID를 통해 특정 일정 수정
* **비밀번호 검증 후 수정 가능**
* 수정 가능 항목

  * 일정 제목
  * 작성자명
* `작성일`은 유지되며 수정 시 `수정일` 자동 갱신
* API 응답에서 **비밀번호 제외**
<img width="2445" height="1293" alt="image" src="https://github.com/user-attachments/assets/c4a03207-892d-4007-83e1-a9f3e4a797a5" />

---

### STEP 4. 일정 삭제

* 일정 ID를 통해 특정 일정 삭제
* **비밀번호 검증 후 삭제 가능**
* 삭제 완료 시 정상 응답 반환
<img width="2467" height="1208" alt="image" src="https://github.com/user-attachments/assets/05604fe2-d2f3-47bc-b0c4-9663b4ea989b" />

---

> ## ✅ 선택 기능 (도전 과제)

### STEP 5. 댓글 생성

* 특정 일정에 댓글 작성 가능
* 댓글 내용, 작성자명, 비밀번호 저장
* 댓글은 반드시 하나의 일정에 종속 (다대일 관계)
* `작성일`, `수정일`은 **JPA Auditing** 적용
* 하나의 일정에는 **최대 10개의 댓글만 등록 가능**
* API 응답에서 **비밀번호 제외**
<img width="2330" height="1084" alt="image" src="https://github.com/user-attachments/assets/b88cce06-19ca-4c28-8d63-af5cd3433d40" />
<img width="1560" height="199" alt="image" src="https://github.com/user-attachments/assets/e8272578-ef38-4bdb-990e-5fc543a2fad8" />

---

### STEP 6. 일정 단건 조회 업그레이드

* 일정 단건 조회 시 해당 일정에 등록된 **댓글 목록 포함**
* 댓글 정보는 Response DTO로 변환하여 반환
* API 응답에서 **비밀번호 제외**
<img width="2406" height="1283" alt="image" src="https://github.com/user-attachments/assets/2fa855e3-c60f-41c7-aef1-09fb3cd2a9d6" />

---

### STEP 7. 입력값 검증

* 사용자 입력값 검증을 통해 잘못된 요청 방지
* 데이터 무결성 및 애플리케이션 예측 가능성 향상
* 검증 조건

  * 일정 제목: 필수, 최대 30자
  * 일정 내용: 필수, 최대 200자
  * 댓글 내용: 필수, 최대 100자
  * 작성자명, 비밀번호: 필수


---

## 설치 방법

* 프로젝트 클론
  * git clone https://github.com/S1K1DA/Ch3-Spring-project01.git
  * Ch3-Spring-project01
 
* 개발 환경
  * Java : 17
  * Spring Boot : 3.x
  * Build Tool : Gradle
  * Database : MySQL
  * ORM : Spring Data JPA
 
---

> ## API 명세서

### 1. 일정 생성 API

URL
```
POST http://localhost:8080/api/schedules
```

Request Body
```
{
  "title": "삭제 테스트 네번째 일정",
  "content": "삭제 테스트 할거임!!",
  "author": "시키",
  "password": "0205"
}
```

Response
```
{
    "id": 4,
    "title": "삭제 테스트 네번째 일정",
    "content": "삭제 테스트 할거임!!",
    "author": "시키",
    "createdAt": "2025-12-31T15:56:07.8097897",
    "modifiedAt": "2025-12-31T15:56:07.8097897"
}
```

### 2. 일정 목록 조회

URL
```
GET http://localhost:8080/api/schedules

```

Response
```
[
    {
        "id": 1,
        "title": "수정된 일정 제목",
        "content": "Postman 테스트용",
        "author": "코더",
        "createdAt": "2025-12-31T14:14:08.418242",
        "modifiedAt": "2025-12-31T15:36:19.009835"
    },
    {
        "id": 3,
        "title": "세 번째 일정",
        "content": "작성자 필터 테스트",
        "author": "테스터",
        "createdAt": "2025-12-31T14:15:01.434436",
        "modifiedAt": "2025-12-31T14:15:01.434436"
    },
    {
        "id": 2,
        "title": "두 번째 일정",
        "content": "목록 조회 테스트",
        "author": "코더",
        "createdAt": "2025-12-31T14:14:43.970457",
        "modifiedAt": "2025-12-31T14:14:43.970457"
    }
]
```

### 3. 일정 작성자 조회

URL
```
GET http://localhost:8080/api/schedules?author=코더

```

Response
```
[
    {
        "id": 2,
        "title": "두 번째 일정",
        "content": "목록 조회 테스트",
        "author": "코더",
        "createdAt": "2025-12-31T14:14:43.970457",
        "modifiedAt": "2025-12-31T14:14:43.970457"
    },
    {
        "id": 1,
        "title": "첫 일정",
        "content": "Postman 테스트용",
        "author": "코더",
        "createdAt": "2025-12-31T14:14:08.418242",
        "modifiedAt": "2025-12-31T14:14:08.418242"
    }
]
```


### 4. 일정 단건 조회

URL
```
GET http://localhost:8080/api/schedules/1

```

Response
```
{
  "id": 1,
  "title": "회의 일정",
  "content": "프로젝트 회의 진행",
  "author": "eunsik",
  "createdAt": "2025-01-01T12:00:00",
  "modifiedAt": "2025-01-01T12:00:00"
}

```

### 5. 일정 수정 API

URL
```
PUT http://localhost:8080/api/schedules/1
```

Request Body
```
{
  "title": "수정된 일정 제목",
  "author": "코더",
  "password": "1234"
}

```

Response
```
{
    "id": 1,
    "title": "수정된 일정 제목",
    "content": "Postman 테스트용",
    "author": "코더",
    "createdAt": "2025-12-31T14:14:08.418242",
    "modifiedAt": "2025-12-31T14:14:08.418242"
}
```


### 6. 일정 삭제 API

URL
```
DELETE http://localhost:8080/api/schedules/4
```

Request Body
```
{
  "password": "0205"
}
```

Response
```
200 OK
삭제 완료
```

### 7. 일정 댓글 등록 API

URL
```
POST http://localhost:8080/api/schedules/1/comments
```

Request Body
```
{
  "content": "댓글 테스트 중",
  "author": "시키",
  "password": "0205"
}
```

Response
```
{
    "id": 1,
    "content": "댓글 테스트 중",
    "author": "시키",
    "createdAt": "2025-12-31T17:50:43.8023512",
    "modifiedAt": "2025-12-31T17:50:43.8023512"
}
```


### 8. 일정 단건 조회(댓글 포함) API

URL
```
GET http://localhost:8080/api/schedules/1/comments
```

Response
```
{
    "id": 1,
    "title": "수정된 일정 제목",
    "content": "Postman 테스트용",
    "author": "코더",
    "createdAt": "2025-12-31T14:14:08.418242",
    "modifiedAt": "2025-12-31T15:36:19.009835",
    "comments": [
        {
            "id": 1,
            "content": "댓글 테스트 중",
            "author": "시키",
            "createdAt": "2025-12-31T17:50:43.802351",
            "modifiedAt": "2025-12-31T17:50:43.802351"
        }
    ]
}
```


> ## ERD
> 
<img width="573" height="561" alt="image" src="https://github.com/user-attachments/assets/2ba05b12-9a2b-47d2-99b8-5505dda7c6fb" />



> ## 과제 문제

### 1. 3 Layer Architecture(Controller, Service, Repository)를 적절히 적용했는지 확인해 보고, 왜 이러한 구조가 필요한지 작성해 주세요.
- Controller, Service, Repository로 역할을 분리하여 개발하였으며 이 구조가 필요한 이유는 각 계층의 역할과 책임이 명확하여 유지보수성이 좋고
  비즈니스 로직과 데이터 접근 로직이 분리되어 가독성과 테스트 용이성이 높아서 좋습니다.

### 2. @RequestParam, @PathVariable, @RequestBody가 각각 어떤 어노테이션인지, 어떤 특징을 갖고 있는지 작성해 주세요.
- @RequestParam은 URL의 Query Paramter 값을 전달받을 때 사용하는 어노테이션이며 선택값으로 사용할수있고 필터 조건 등에 주로 활용합니다!
- @PathVariable은 URL 경로에 포함된 값을 변수로 전달받을때 사용하는 어노테이션입니다! 주로 특정 식별하는 ID 값 전달에 사용합니다!
- @RequestBody는 HTTP요청 Body에 담긴 JSON 데이터를 자바 객체로 변환할때 사용합니다! POST,PUT,DELETE 요청에서 주로 활용합니다!!



