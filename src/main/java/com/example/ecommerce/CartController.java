package com.example.ecommerce;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private List<CartItem> cartItems = new ArrayList<>();

    @GetMapping
    public List<CartItem> viewCart() {
        return cartItems;
    }

    @PostMapping
    public CartItem addItemToCart(@RequestBody CartItem cartItem) {
        cartItems.add(cartItem);
        return cartItem;
    }

    @DeleteMapping("/{id}")
    public String removeItemFromCart(@PathVariable Long id) {
        cartItems.removeIf(item -> item.getId().equals(id));
        return "Item removed from cart";
    }
}
