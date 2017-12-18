package com.shopping.online.cart;

import java.util.ArrayList;
import java.util.List;

import com.shopping.online.coupons.AbstractCoupon;
import com.shopping.online.products.AbstractProduct;

public class Cart {

	// region: Instance variables
	private ICartItem firstItem;
	private ICartItem lastItem;
	private float cartTotal;

	private ArrayList<CartProductWrapper> cartProducts;
	private ArrayList<CartCouponWrapper> cartCoupons;

	// region: Class Initializers
	private Cart() {

		this.clear();

		this.cartProducts = new ArrayList<CartProductWrapper>();
		this.cartCoupons = new ArrayList<CartCouponWrapper>();
	}

	public static Cart initialize() {
		Cart cart = new Cart();
		return cart;
	}

	// region: Getters and setters
	public ICartItem getFirstItem() {
		return firstItem;
	}

	private void setFirstItem(ICartItem firstItem) {
		this.firstItem = firstItem;
	}

	private ICartItem getLastItem() {
		return lastItem;
	}

	private void setLastItem(ICartItem lastItem) {
		this.lastItem = lastItem;
	}

	public float getCartTotal() {
		return cartTotal;
	}

	private void setCartTotal(float cartTotal) {
		this.cartTotal = cartTotal;
	}

	public List<CartCouponWrapper> getCoupons() {
		return cartCoupons;
	}

	public List<CartProductWrapper> getProducts() {
		return cartProducts;
	}

	// region: Utility Methods

	// Manage Products list
	private void addProduct(CartProductWrapper product) {
		this.cartProducts.add(product);
	}

	// Manage Coupons list
	private void addCoupon(CartCouponWrapper coupon) {
		this.cartCoupons.add(coupon);
	}

	// Add product to products list and cart ledger
	public void addCartItem(AbstractProduct product) {
		CartProductWrapper Product = CartProductWrapper.wrap(product);
		addProduct(Product);
		addCartItem(Product);
	}

	// Add coupon to coupons list and cart ledger
	public void addCartItem(AbstractCoupon coupon) {

		CartCouponWrapper Coupon = CartCouponWrapper.wrap(coupon);
		addCoupon(Coupon);
		addCartItem(Coupon);
	}

	// Cart ledger is the backbone of this application.
	// It maintains the sequence of inclusion allowing complex coupon logic.
	private void addCartItem(ICartItem cartItem) {

		if (getFirstItem() == null) {
			setFirstItem(cartItem);
			setLastItem(cartItem);
		}

		else {
			cartItem.setPreviousCartItem(getLastItem());
			getLastItem().setNextCartItem(cartItem);
			setLastItem(cartItem);
		}

		processCart();
	}

	private void processCart() {

		for (CartProductWrapper product : getProducts()) {
			product.resetDiscounts();
		}

		for (CartCouponWrapper coupon : getCoupons()) {
			coupon.validateAndApply(this);
		}

		float total = 0;
		for (CartProductWrapper product : getProducts()) {
			total += product.getReducedCost();
		}

		setCartTotal(total);
	}

	public void clear() {
		setFirstItem(null);
		setLastItem(null);
	}
}
