package edu.du.shoppingmall.controller;

import edu.du.shoppingmall.entity.Cart;
import edu.du.shoppingmall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/user/cart")  // /cart -> /user/cart로 경로 수정
public class CartController {

    @Autowired
    private CartService cartService;

    // 장바구니에 추가된 항목을 조회하는 API
    @GetMapping
    public List<Cart> getCartItems() {
        List<Cart> cartItems = cartService.getAllCartItems();
        return cartItems;
    }


    // 장바구니에 항목을 추가하는 API
    @PostMapping("/add")
    public String addToCart(@RequestBody Cart cart) {
        if (cart.getPrice() == null || cart.getTotal() == null) {
            return "fail"; // 필수 데이터 누락 시 처리
        }

        cartService.addOrUpdateCart(cart);
        return "success";
    }

    // 장바구니 항목 삭제하는 API
    @DeleteMapping("/remove/{cartId}")
    public String removeFromCart(@PathVariable Long cartId) {
        cartService.removeCartItem(cartId);
        return "success";
    }
}
