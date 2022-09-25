# 도커 - SpringBoot jar 파일 찾기

분류: Server
생성일: 2022년 9월 24일 오후 8:40
작성자: 창모 연
태그: Docker, Jenkins, gradle, maven

도커 파일을 작성을 통해 스프링부트의 jar를 실행시켜 서버 백엔드를 동작시킨다.

하지만 깃랩 프로젝트를 작업 경로로 설정하면 .gitignore 파일 설정때문에 build 폴더가 없다.

gradle 기준 build/libs 폴더 하위에 jar 파일이 존재하고,

![Untitled](%E1%84%83%E1%85%A9%E1%84%8F%E1%85%A5%20-%20SpringBoot%20jar%20%E1%84%91%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%AF%20%E1%84%8E%E1%85%A1%E1%86%BD%E1%84%80%E1%85%B5%2086af4763697d4977abd9aa0a9f2cbd1e/Untitled.png)

maven 기준 target 폴더 하위에 jar 파일이 존재한다.

![Untitled](%E1%84%83%E1%85%A9%E1%84%8F%E1%85%A5%20-%20SpringBoot%20jar%20%E1%84%91%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%AF%20%E1%84%8E%E1%85%A1%E1%86%BD%E1%84%80%E1%85%B5%2086af4763697d4977abd9aa0a9f2cbd1e/Untitled%201.png)

하지만 깃랩 프로젝트로 가보면 build 폴더가 없는 것을 확인할 수 있다.

![캡처.PNG](%E1%84%83%E1%85%A9%E1%84%8F%E1%85%A5%20-%20SpringBoot%20jar%20%E1%84%91%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%AF%20%E1%84%8E%E1%85%A1%E1%86%BD%E1%84%80%E1%85%B5%2086af4763697d4977abd9aa0a9f2cbd1e/%25EC%25BA%25A1%25EC%25B2%2598.png)

그렇다면 깃랩과 연결한 프로젝트는 jar 파일을 어디서 찾아서 이용해야하는가

젠킨스 Build - Execute shell에 도커 파일 실행 전 빌드를 하도록 하였다.

![Untitled](%E1%84%83%E1%85%A9%E1%84%8F%E1%85%A5%20-%20SpringBoot%20jar%20%E1%84%91%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%AF%20%E1%84%8E%E1%85%A1%E1%86%BD%E1%84%80%E1%85%B5%2086af4763697d4977abd9aa0a9f2cbd1e/Untitled%202.png)

```jsx
명령어 설명
1. 작업 경로 진입
cd /var/jenkins_home/workspace/deploytest/BE/percast

2. 권한 설정 ( 바로 3번을 했더니 권한 오류가 발생했다. )
chmod +x gradlew

3. 기존 빌드 파일 제거 후 새로 생성
./gradlew clean build

4. 도커 이미지 빌드하기
docker build -t springboot .

```

해당 방법이 정답이 아니니 참고만 하시기 바랍니다.