package edu.du.shoppingmall;

import edu.du.shoppingmall.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class ShoppingmallApplicationTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void insert_test() {
        Member member = Member.builder()
                .memberName("장수영")
                .password("1234")
                .email("syjang@korea.com")
                .memberAddress("경기도 구리시 동구릉로 129번길 24")
                .role("admin")
                .regdate(LocalDateTime.now())
                .build();
        System.out.println(memberRepository.save(member));
    }

}
