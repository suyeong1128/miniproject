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
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 증가 ID
    private Long productId;

    @Column(nullable = false, length = 100)  // 제품 이름 (필수, 최대 길이 100)
    private String productName;

    @Column(columnDefinition = "TEXT")  // 제품 설명 (TEXT)
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)  // 가격 (소수점 2자리까지)
    private BigDecimal price;

    @Column(nullable = false, columnDefinition = "int default 0")  // 재고 수량
    private Integer stock = 0;
}
