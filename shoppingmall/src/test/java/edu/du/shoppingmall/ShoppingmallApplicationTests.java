package edu.du.shoppingmall;

import edu.du.shoppingmall.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class ShoppingmallApplicationTests {
    @Autowired
    UserRepository userRepository;

    @Test
    void insert_test() {
        Member user = Member.builder()
                .memberName("장수영")
                .password("1234")
                .email("syjang@korea.com")
                .role("admin")
                .regdate(LocalDateTime.now())
                .build();
        System.out.println(userRepository.save(user));
    }

}
