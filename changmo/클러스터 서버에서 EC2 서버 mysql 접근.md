# 클러스터 서버에서 EC2 서버 mysql 접근

분류: Server
생성일: 2022년 9월 24일 오후 9:12
작성자: 창모 연
태그: Docker, MySQL

기존 docker-compose.yml 파일에 db 설정을 image: mysql 로 했었다.

💣 **캡쳐는 변경된 내용입니다.**

![Untitled](%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A5%E1%84%89%E1%85%B3%E1%84%90%E1%85%A5%20%E1%84%89%E1%85%A5%E1%84%87%E1%85%A5%E1%84%8B%E1%85%A6%E1%84%89%E1%85%A5%20EC2%20%E1%84%89%E1%85%A5%E1%84%87%E1%85%A5%20mysql%20%E1%84%8C%E1%85%A5%E1%86%B8%E1%84%80%E1%85%B3%E1%86%AB%202181f506997f4eee9095de0f43e219e6/Untitled.png)

그랬더니 DB 외부 사용을 위한 파일 수정에 문제가 생겼다.

mysql 컨테이너로 들어간 뒤 my.cnf 파일을 찾아 수정하려했지만

리눅스 기본 명령어인 vi, vim, nano, apt, apt-get 등이 command not found 에러가 발생했다. 

```jsx
1. mysql 컨테이너 id 확인을 위해 현재 돌아가고 있는 컨테이너를 확인하기 위한 명령어
sudo docker ps

2. mysql 컨테이너 안으로 들어가는 명령어
sudo docker exec -it [mysql컨테이너id] /bin/bash

3. my.cnf 파일 수정을 위한 파일 열기 명령어
vi my.cnf # command not found (vi)
vim my.cnf # command not found (vim)
nano my.cnf # command not found (nano)

4. vim 명령어 다운을 위한 apt-get install 사용
apt-get install vim # command not found (apt-get)
apt-get install vi # command not found (apt-get)

// mysql 기준
cd etc
vim my.cnf

// mysql:8.0.30:debian 기준
cd etc/mysql
vim my.cnf
```

검색해보니

docker-compose.yml 파일에 db 이미지를 mysql로 설정하면 기본 명령어를 제공하지 않는단다.

기본 명령어를 사용하기 위해선 debian 버전을 설치해야한다.

본인이 사용하고자 하는 컨테이너의 버전을 찾아보기 위해 docker hub 에 직접 들어가보는걸 권장한다.

[도커허브Mysql](https://hub.docker.com/_/mysql)

[mysql - Official Image | Docker Hub](https://hub.docker.com/_/mysql)

2022년 9월 24일 기준 제공하는 버전

![Untitled](%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A5%E1%84%89%E1%85%B3%E1%84%90%E1%85%A5%20%E1%84%89%E1%85%A5%E1%84%87%E1%85%A5%E1%84%8B%E1%85%A6%E1%84%89%E1%85%A5%20EC2%20%E1%84%89%E1%85%A5%E1%84%87%E1%85%A5%20mysql%20%E1%84%8C%E1%85%A5%E1%86%B8%E1%84%80%E1%85%B3%E1%86%AB%202181f506997f4eee9095de0f43e219e6/Untitled%201.png)

원하는 버전을 확인한 후 EC2 서버의 docker-compose.yml 파일을 수정한다. (작성자 기준)

![Untitled](%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A5%E1%84%89%E1%85%B3%E1%84%90%E1%85%A5%20%E1%84%89%E1%85%A5%E1%84%87%E1%85%A5%E1%84%8B%E1%85%A6%E1%84%89%E1%85%A5%20EC2%20%E1%84%89%E1%85%A5%E1%84%87%E1%85%A5%20mysql%20%E1%84%8C%E1%85%A5%E1%86%B8%E1%84%80%E1%85%B3%E1%86%AB%202181f506997f4eee9095de0f43e219e6/Untitled.png)

```jsx
1. 도커 컴포즈 파일 작성을 마치고 실행 
( -d 는 옵션, 데몬, 실행되는 것이 안나옴, 나오길 원한다면 빼도 됨)
sudo docker-compose up -d

2. 도커 컴포즈 파일 안에 작성된 컨테이너들이 돌아가는지 확인하는 명령어
sudo docker-compose ls
```

docker-compose 사용을 위한 yml, yaml 파일을 작성하지 않고 직접 도커 컨테이너를 pull 받고 run 시켜도 된다.

```jsx
1. 원하는 버전을 다운받는다.
sudo docker pull mysql # 최신 버전을 다운로드
sudo docker pull mysql:8.0.30:debian # 버전 지정

2. 다운 받은 도커 이미지 확인
sudo docker images

3. 도커 컨테이너 생성 및 실행 ( 여러 방법이 있다. 검색해서 사용하길 권장한다.)
sudo docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=<password> -d -p 3306:3306 mysql:latest
docker run : 도커 컨테이너 생성 및 실행 명령어
docker run 은 하위 2개의 명령어를 합친 것
docker create : 도커 컨테이너 생성
docker start : 도커 컨테이너 실행

--name mysql-container : 컨테이너 이름 지정 mysql-container 대신 원하는 이름 입력
-e MYSQL_ROOT_PASSWORD=<password> : ROOT 계정 비밀번호 지정
-d : 데몬 실행 ( 실행되는 것이 화면에 안나온다. 에러떠서 실행 안돼도 모른다. 빼도 된다.)
-p 3306:3306 : 포트 포워딩 ( 외부접근 포트 : 내부접근 포트 지정)

4. 동작 확인
sudo docker ps -a

-a : 옵션, 생성된 컨테이너 중 지금 안돌아가는 것도 다나온다. ( 빼도 됨)

```

mysql 컨테이너를 다시 설치 후, mysql 컨테이너 내부로 들어가 my.cnf 파일을 수정한다.

```jsx
1. mysql 컨테이너 id 확인을 위해 현재 돌아가고 있는 컨테이너를 확인하기 위한 명령어
sudo docker ps

2. mysql 컨테이너 안으로 들어가는 명령어
sudo docker exec -it [mysql컨테이너id] /bin/bash

3. vim 명령어 다운을 위한 apt-get install 사용
apt-get install vim # 이젠 apt-get 명령어 돌아갔다.
apt-get install vi

4. my.cnf 파일 수정을 위한 파일 열기 명령어
vi my.cnf 
vim my.cnf 

// mysql 기준 ( 작성자 기준)
cd etc
vim my.cnf

// mysql:8.0.30:debian 기준 (작성자 기준)
cd etc/mysql
vim my.cnf

my.cnf 파일의 secure-file-priv 값 수정
기존
secure-file-priv = "파일 경로"
또는
secure-file-priv = NULL
을
secure-file-priv = ""
로 변경한다.
```

![Untitled](%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A5%E1%84%89%E1%85%B3%E1%84%90%E1%85%A5%20%E1%84%89%E1%85%A5%E1%84%87%E1%85%A5%E1%84%8B%E1%85%A6%E1%84%89%E1%85%A5%20EC2%20%E1%84%89%E1%85%A5%E1%84%87%E1%85%A5%20mysql%20%E1%84%8C%E1%85%A5%E1%86%B8%E1%84%80%E1%85%B3%E1%86%AB%202181f506997f4eee9095de0f43e219e6/Untitled%202.png)

변경 후 해당 컨테이너를 다시 실행시켜야 적용이 된다.

```jsx
컨테이너를 빠져나가는 방법
exit

컨테이너를 빠져나와 다시 ec2 서버로 와서 다시 컨테이너를 실행 시켜준다.
작성자 기준 docker-compose 재실행
sudo docker-compose up -d

컨테이너 재실행 ( 이건 안해봐서 되는지 잘 모르겠다.)
sudo docker ps
sudo docker restart [mysql 컨테이너 이름]

이후 잘 적용됐는지 확인
1. mysql 컨테이너 안으로 들어가는 명령어
sudo docker exec -it [mysql컨테이너id] /bin/bash

2. vim 명령어 다운을 위한 apt-get install 사용
apt-get install vim # 이젠 apt-get 명령어 돌아갔다.
apt-get install vi

3. my.cnf 파일 수정을 위한 파일 열기 명령어
vi my.cnf 
vim my.cnf 

// mysql 기준 ( 작성자 기준)
cd etc
vim my.cnf

mysql 실행으로 확인
mysql 컨테이너 내부에서

mysql -uroot -p
비밀번호 입력

mysql 이 실행되면
SHOW VARIABLES LIKE "secure_file_priv"; 

value 가 비어있는 것을 확인하면 성공
```

![Untitled](%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A5%E1%84%89%E1%85%B3%E1%84%90%E1%85%A5%20%E1%84%89%E1%85%A5%E1%84%87%E1%85%A5%E1%84%8B%E1%85%A6%E1%84%89%E1%85%A5%20EC2%20%E1%84%89%E1%85%A5%E1%84%87%E1%85%A5%20mysql%20%E1%84%8C%E1%85%A5%E1%86%B8%E1%84%80%E1%85%B3%E1%86%AB%202181f506997f4eee9095de0f43e219e6/Untitled%203.png)