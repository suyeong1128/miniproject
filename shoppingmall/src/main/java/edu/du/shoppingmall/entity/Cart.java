package edu.du.shoppingmall.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @Column
    private String productName;

    @Column(nullable = false, precision = 10, scale = 2)  // 가격 (소수점 2자리까지)
    private BigDecimal price;

    @Column
    private Long total;
}
