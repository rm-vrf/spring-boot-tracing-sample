# spring-boot-tracing-sample

Spring Boot 跟踪示例

```
bin/elasticsearch -E cluster.name=log_store

java -jar zipkin-server-2.11.8-exec.jar --STORAGE_TYPE=elasticsearch --ES_HOSTS=localhost:9200

java -jar gateway/target/tracing-sample-gateway-1.0.0-SNAPSHOT.jar

java -jar front/target/tracing-sample-front-1.0.0-SNAPSHOT.jar --back.url=http://localhost:8082

java -jar back/target/tracing-sample-back-1.0.0-SNAPSHOT.jar
```

```
$ curl -i 'http://localhost:8080/_cat/indices'
HTTP/1.1 200
Content-Type: text/plain;charset=UTF-8
Transfer-Encoding: chunked
Date: Sat, 01 Dec 2018 15:47:33 GMT

yellow open logstash-2018.11.29    -v7mvMLOQH6W7glRWqzeBw 5 1 213 0   326kb   326kb
yellow open zipkin:span-2018-11-30 QJLaBhGlQvuVEgyQmJeNOg 5 1  94 0 202.1kb 202.1kb
yellow open zipkin:span-2018-12-01 06QGLghNSRGepA8sA4iB1g 5 1 168 0 423.6kb 423.6kb
yellow open logstash-2018.11.30    kEQq1cvBQv2FRSCSNkMkCg 5 1  57 0 149.9kb 149.9kb
yellow open .kibana                UCAQ-jTATVqt8AiRFfaUCg 1 1   2 1  14.1kb  14.1kb
```

```
$ curl -i 'http://localhost:8080/front/api/v1/test'
HTTP/1.1 200
Content-Type: text/plain;charset=UTF-8
Content-Length: 103
Date: Sat, 01 Dec 2018 15:42:46 GMT

Message from backend: ["Hello, sleep time: 1509", "[{Host=%, User=root}, {Host=localhost, User=root}]"]
```
