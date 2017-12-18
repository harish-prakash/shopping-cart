package com.shopping.online.coupons;

import java.util.UUID;

import com.shopping.online.cart.Cart;
import com.shopping.online.cart.CartProductWrapper;
import com.shopping.online.cart.ICartItem;

public class CouponPercentOffItemTypeWhenCartTotalExceeds extends AbstractCoupon {

	// region: Instance Variables
	private Class<?> productType;
	private float discountPercent;
	private float cartTotalThreshold;

	// region: Class Initializers
	private CouponPercentOffItemTypeWhenCartTotalExceeds(String title, Class<?> productType, float discountPercent, float cartTotalThreshold) {
		super(title);
		setProductType(productType);
		setDiscountPercent(discountPercent);
		setCartTotalThreshold(cartTotalThreshold);
	}
	
	public static AbstractCoupon instance(String title, Class<?> productType, float discountPercent, float cartTotalThreshold) {
		
		CouponPercentOffItemTypeWhenCartTotalExceeds coupon = new CouponPercentOffItemTypeWhenCartTotalExceeds(title, productType, discountPercent, cartTotalThreshold);
		return coupon;
	}
	
	// region: Getters and Setters

	private Class<?> getProductType() {
		return productType;
	}

	private void setProductType(Class<?> productType) {
		this.productType = productType;
	}

	private float getDiscountPercent() {
		return discountPercent;
	}

	private void setDiscountPercent(float discountPercent) {
		this.discountPercent = discountPercent;
	}

	private float getCartTotalThreshold() {
		return cartTotalThreshold;
	}

	private void setCartTotalThreshold(float cartTotalThreshold) {
		this.cartTotalThreshold = cartTotalThreshold;
	}

	// region: Overridden Methods
	@Override
	public UUID getCouponID() {

		return UUID.fromString("ae1e8ac9-99f1-453e-92e0-e34b1703bec2");
	}

	@Override
	public void applyCoupon(Cart targetCart, ICartItem cartCouponInstance) {

		if (targetCart.getCartTotal() > getCartTotalThreshold()) {
			ICartItem cartItem = targetCart.getFirstItem();

			while (cartItem != null) {
				try {
					if (cartItem instanceof CartProductWrapper) {

						CartProductWrapper Product = (CartProductWrapper) cartItem;
						getProductType().cast(Product.getProduct());
						float reducedCost = Product.getReducedCost();

						reducedCost *= 1 - getDiscountPercent() / 100;
						Product.setReducedCost(reducedCost);
						Product.tagAppliedCoupon(this);
						break;
					}
				} catch (java.lang.ClassCastException ex) {}

				cartItem = cartItem.getNextCartItem();
			}
		}
	}

}
