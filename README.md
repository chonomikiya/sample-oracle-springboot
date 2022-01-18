# sample-oracle-springboot
### 参考資料

[DockerでOracle動かしたついでに、公式サンプルデータを突っ込んでから、ER図を自動生成してみようぜ](https://zenn.dev/angelica/articles/9e2411db5fc1b7)

[DockerでOracle Databaseを使う](https://qiita.com/gorilla0513/items/f22e8cce4e08da031abe)

[Oracle 11 g + Spring boot を Vagrant + Docker compose で試してみたメモ](https://qiita.com/hibohiboo/items/82f018a5824f4ed5e64f)

前提としてoracle database19.3.0のイメージを準備している。

ほぼ資料通りなのでリンク先を見たほうが早かったりする。

---

起動
```
docker-compose up -d dbserver
docker logs -f docker_dbserver_1
```

作成が終わったらテーブルを作る。

```
$ sqlplus system/MYPASS@MYPDB
SQL @/u01/app/oracle/oradata/create.sql
SQL @/u01/app/oracle/oradata/mydate.sql
```
docker/gradle/Dockerfile
```
FROM gradle:7.3.3-jdk11 
WORKDIR /app
```
docker/spring/Dockerfile
```
FROM openjdk:11 
WORKDIR /app 
ENV JAVA_OPTS=""
```

springのソースは各自用意。

JDBCの記述
src/sample-springboot/src/main/resources/application.properties
```
spring.datasource.url=jdbc:oracle:thin:@//dbserver:1521/ORCLPDB 
spring.datasource.username=user01 
spring.datasource.password=user01 
spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
```
Gradleのビルド
```
docker-compose run gradle gradle clean build
```
Springの起動
```
docker-compose up -d
```