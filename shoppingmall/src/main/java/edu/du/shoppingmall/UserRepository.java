package edu.du.shoppingmall;

import edu.du.shoppingmall.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Member, Long> {
}
