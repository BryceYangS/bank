# API Gateway

## 1. API Gateway란?
- 다수의 서비스로 구성된 Micro Service들에서 각 서비스들의 IP와 Port 번호들에 대한 단일화된 엔드포인트 제공
- 각 서비스들에서 필요한 인증/인가, 사용량 제어, 요청/응답 변조 등의 기능을 대신 담당

### Spring Gateway 기능
- Service Request 라우팅
- Service Load Balancing
- Service Request에 대한 Endpoint 단일화
- Service Mesh와 연계를 통한 장애 대응
- Service Filtering
- Authentication / Authorizing
- Logging / Monitoring


## 2. 적용방법

### 의존성 추가
- build.gradle
    1. `spring cloud gateway` 의존성 추가 (spring boot starter 필요 없음)
    2. eureka client 추가
    ```gradle
    dependencies {
        implementation 'org.springframework.cloud:spring-cloud-starter-gateway'
        implementation 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-client'
    
        testImplementation('org.springframew
  ork.boot:spring-boot-starter-test') {
            exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
        }
    }
    
    ext {
        set('springCloudVersion', "Hoxton.SR8")
    }
    
    dependencyManagement {
        imports {
            mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
        }
    }
    ```
  
### application.yml 파일
- Spring cloud Gateway 설정
    + `id` : routing에 사용할 id
    + `uri`: [Load Balancing]://[Eureka에 등록한 서비스명]
    + `predicates` : - Path=[API Gateway주소 뒤에 올 서비스명] 
    ```yaml
    spring:
      application:
        name: minibank-apigateway
      cloud:
        gateway:
          default-filters:
            - DedupeResponseHeader=Access-Control-Allow-Origin Access-Control-Allow-Credentials, RETAIN_UNIQUE
          globalcors:
            cors-configurations:
              '[/**]':
                allowed-origins: "*"
                allowed-methods: "*"
                allowed-headers: "*"
                allow-credentials: true
          routes:
            - id: minibank-account
              uri: lb://MINIBANK-ACCOUNT
              predicates:
                - Path=/minibank/account/**
            - id: minibank-coustomer
              uri: lb://MINIBANK-CUSTOMER
              predicates:
                - Path=/minibank/customer/**
            - id: minibank-transfer
              uri: lb://MINIBANK-TRANSFER
              predicates:
                - Path=/minibank/transfer/**
    ```