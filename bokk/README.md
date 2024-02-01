# 프로젝트 명

---

### 4세에서 10세 아이들이 함께 참여 가능한 화상 동화 서비스
<br><br>

# 팀원
---
|   **Name**   |                김대영                 |                박성진                |                  이준서                   |               김규리                |                 류태수                  |               박종혁                |
| :----------: | :-----------------------------------: | :----------------------------------: | :---------------------------------------: | :---------------------------------: | :-------------------------------------: | :---------------------------------: |
| **Profile**  |     |    |         |   |       |   |
| **Position** |          Backend <br> Leader           |          Backend           |           Backend          |        Frontend <br> Leader         |            Frontend            |         Frontend          |

<br><br>

# 📚기술 스택
| Tech         | Stack                                  |
| ------------ | -------------------------------------- |
| **Language** | Java, JavaScript                       |
| **Backend**  | Spring Boot, JPA, Spring Security, JWT |
| **Frontend** | React                                  |
| **Database** | MySQL, Redis, AWS S3                   |
| **Server**   | AWS EC2, NginX                         |
| **DevOps**   | GitLab, Docker                         |

<br><br>

# 커밋 컨벤션
| Type         | 설명                                                                        |
| ------------ | --------------------------------------------------------------------------- |
| **Feat**     | 새로운 기능 추가                                                              |
| **Fix**      | 버그 수정                                                                    |
| **Refactor** | 리펙토링                                                                     |
| **Design**   | CSS등 사용자 UI 디자인 변경                                                   |
| **Comment**  | 주석 추가 / 변경                                                             |
| **Style**    | 코드 포맷팅, 세미콜론 누락, 코드 변경 없는 경우                                  |
| **Docs**     | 문서 추가, 수정, 삭제                                                         |
| **Test**     | 테스트 관련 코드 추가, 수정, 삭제과 비즈니스 로직 변경 없는 경우                   |
| **Chore**    | 위에 걸리지 않는 기타 변경사항(빌드 스크립트 수정, assets image, 패키지 매니저 등)  |
| **Init**     | 프로젝트 초기 생성                                                            |
| **Rename**   | 파일 혹은 폴더명 수정하거나 옮기는 경우                                          |
| **Remove**   | 파일을 삭제하는 작업만 수행하는 경우                                             |

<br><br>

# 배경

---

동화가 아이들에게 긍정적인 영향을 미친다는 것은 이미 대부분의 사람들이 알고 있다. 

- **언어 발달과 책 읽기 습관 형성**에 많은 도움을 준다.
- 다양한 상황과 캐릭터를 간접적으로 체험해보면서 **상상력과 창의력 발달에 많은 도움**이 된다.
- **이야기 속에 녹아 있는 교훈을 느낄 수 있다.**
<br>
하지만 이렇게 좋은 동화를 접할 기회가 점점 줄어들고 있다. 

- 맞벌이 가정이 늘어남에 따라 **부모님이 동화를 읽어줄 기회가 줄어들었다.**
- 스마트 기기의 발달로 **자극적이고 흥미 위주인 컨텐츠들이 자리잡으면서 아이들이 스스로 동화를 읽는 경우가 줄어들었다.**
<br>
이러한 상황에서 아이들에게 동화책을 읽을 수 있도록 도와주는 여러 교육 서비스들이 만들어졌다. 
<br>하지만 기존 서비스들( 아이들나라, 밀크T, 밀리의 서재 등 )에서 몇 가지 아쉬운 부분을 발견했다.

- 동화책을 읽는 과정에서 **능동적인 참여가 불가능**하여 **흥미를 쉽게 잃을 수 있다.**
- 동화책을 읽는 활동에 대한 결과물이 남지 않아 **부모의 경우 아이들이 제대로 참여하는 지 알 수 없고**, 아이들의 경우 **성취감이 없어 오랫동안 활동을 지속하는 것이 어렵다.**
- **단순히 혼자서 동화를 읽도록 하기 때문에 어릴 때부터 길러주어야 할 다른 성향들을 기르는 데에는 아쉬움**이 있다.
- 기존 동화책들은 이미 결말이 정해져 있기 때문에 결말을 알고 있을 경우, **동화 내용 흐름에 대한 집중도가 떨어진다.**

<br><br>

# 목표

---

1. 동화책을 읽는 과정에서 실시간으로 **능동적인 참여가 가능 하도록** 서비스를 만든다.
<br>

2. 동화책을 읽는 활동에 대한 결과물을 생성하여 부모는 **아이들의 참여도를 체크** 할 수 있다.
<br> 

3. **아이들은 그 결과물을 통해 성취감**을 느낄 수 있도록 하여 **꾸준한 참여를 유도**하도록 한다.
<br>

4. 여러 친구들과 함께 동화책을 읽으면서 **아이들의 사회성 형성에도 도움**을 주도록 한다.
<br>

5. 간단한 선택지를 통해 **하나의 동화에서도 다양한 결말**이 나오도록 만들어 **흥미를 유지하도록 유도**한다.

<br><br>

# 주요 기능

---

1. 혼자 녹화 / 함께 녹화 선택 기능
    <br>a. 혼자 녹화 시 다른 역할들은 AI  또는 사전 녹음된 사운드로 대체
<br>

2. 원하는 역할 선택 기능
    <br>a. 원하는 역할 선택 후 자동으로 방 배정
<br>

3. 실시간 웹캠 공유 기능
    <br>a. 참여하는 아이의 얼굴에 동화 속 맡은 역할의 필터 씌우기
<br>

4. 참여 도우미 캐릭터 시스템
<br>

5. 자동 녹화/녹음 기능
    <br>a. 본인 차례가 올 경우, 주어진 시간 내 대사를 처리. 시간이 지나면 자동으로 다음 내용으로 진행.
<br>

6. 선택지에 따라 나뉘는 다양한 결말
<br>

7. 동화가 끝난 후, 아이들이 연기한 화면들을 하나의 동화로 재구성
    <br>a. 저장된 동화 영상 다시보기 / 다운로드

<br><br>