# Getting Started

### API 서버 만들기
서버의 목적은 서버 구축 및 배포 등 백엔드에 대한 이해를 위함.

1. OS : mac m2
2. java version : 11
3. DB : postgres

### 패키지 구조

        dev
            api(회원가입 및 jwt 토큰 구현 security는 보완 필요.)
                account(도메인)
                    controller
                    dto
                        request
                        response
                    entity
                    exception
                    repository
                    service
                config
                jwt
                    dto
                    entity
        mainApplication
            

### 노션 페이지  
* 노션 링크 : <https://www.notion.so/JAVA-75105ed2aba243ad9817bcde8f770959?pvs=4>