# JAVA Servlet

### 프로젝트 목적

servlet를 이용한 spring MVC 이해하기.
Http에 대한 전반적인 이해 및 개념파악.

### 구축 환경
1. OS : mac m2
2. java version : 17
3. IDE : intellij
4. 참고 강의 : inflearn 김영한

#### 패키지 설명
1. 최상의 패키지 servlet.basic, servlet.domain, servlet.web
    basic( servelt에 대한 기초 실습), domain(Entity및 저장소) , web(servlet에 대한 전반적인 실습.)
2. servlet.web.~은 단계별로 servlet에 대한 이해.
    servlet(servlet을 사용한 간단한 실습), servletmvc(mvc패턴을 이용한 servlet 실습) 
  , frontcontroller(frontcontorller을 도입하여, 단계별로 리펙토링)
3. servlet.web.frontcontroller~은 frontcontroller도입 및 MVC 패턴에 대한 리펙토링
   + servlet.web.frontcontroller.v1(다형성을 이용한 mvc패턴, frontcontroller 도입)
   + servlet.web.frontcontroller.v2(view에 대한 구분)
   + servlet.web.frontcontroller.v3(servlet에 대한 종속성 제거 및 view resolver 사용,model 추가)
   + servlet.web.frontcontroller.v4(controller 단순화. interface의 변화)
   + servlet.web.frontcontroller.v5(유연한 컨트롤러 , 어댑터 패턴, handler 사용, controllerV3,controllerV4사용)
  


##### 메모
1. 추상적인 인터페이스에만 의존하도록 설계.(실제 구현체가 어떻게 되든 상관 없음)
2. singleton,adapter 패턴 이해하기
