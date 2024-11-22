package edu.du.shoppingmall.service;

import edu.du.shoppingmall.CartRepository;
import edu.du.shoppingmall.entity.Cart;
import edu.du.shoppingmall.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getAllCartItems() {
        return cartRepository.findAll(); // 장바구니 항목 전체 조회
    }

    @Override
    public void removeCartItem(Long id) {
        cartRepository.deleteById(id); // ID 기준으로 항목 삭제
    }

    @Override
    public void addOrUpdateCart(Cart cart) {
        // 동일한 상품명을 가진 항목이 있는지 확인
        Cart existingCart = cartRepository.findByProductName(cart.getProductName());

        if (existingCart != null) {
            // 기존 항목이 있으면 수량 업데이트
            existingCart.setTotal(existingCart.getTotal() + cart.getTotal());
            cartRepository.save(existingCart);
        } else {
            // 기존 항목이 없으면 새로 추가
            cartRepository.save(cart);
        }
    }
}
