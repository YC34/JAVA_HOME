package com.dev.api.account.repository;

import com.dev.api.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AccountRepository extends JpaRepository<Account,Long> {

    boolean existsByEmail(String email);


    // null값 체크를 위해 Optional 객체를 사용. null을 리턴하는 것이 아닌 Optional객체를 리턴하므로 null값에 대한 처리를 할 수 있다.
    // java 8 부터 지원한다.
    Optional<Account> findByEmail(String email);
}
