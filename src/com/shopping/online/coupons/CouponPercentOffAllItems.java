package com.shopping.online.coupons;

import java.util.UUID;

import com.shopping.online.cart.Cart;
import com.shopping.online.cart.CartProductWrapper;
import com.shopping.online.cart.ICartItem;

public class CouponPercentOffAllItems extends AbstractCoupon {

	//region: Instance Variables
	private float discountPercent;
	
	private CouponPercentOffAllItems(String title, float discountPercent, boolean allowMultipleUse) {
		super(title);
		setDiscountPercent(discountPercent);
		setAllowMultiUse(allowMultipleUse);
	}
	
	public static AbstractCoupon instance(String title, float discountPercent, boolean allowMultipleUse) {
		
		CouponPercentOffAllItems coupon = new CouponPercentOffAllItems(title, discountPercent, allowMultipleUse);
		return coupon;
	}

	//region: Getters and Setters
	@Override
	public UUID getCouponID() {

		return UUID.fromString("7fe46c94-3456-4acc-8b1c-dd4ab34ff48f");
	}

	private float getDiscountPercent() {
		return discountPercent;
	}

	private void setDiscountPercent(float discountPercent) {
		this.discountPercent = discountPercent;
	}

	@Override
	public void applyCoupon(Cart targetCart, ICartItem cartCouponInstance) {
		
		ICartItem cartItem = targetCart.getFirstItem();
		
		while(cartItem != null) {
			
			if (cartItem instanceof CartProductWrapper) {
				
				CartProductWrapper Product = (CartProductWrapper) cartItem;
				float reducedCost = Product.getReducedCost();
				
				reducedCost *= 1 - getDiscountPercent()/100;
				Product.setReducedCost(reducedCost);
				Product.tagAppliedCoupon(this);
			}

			cartItem = cartItem.getNextCartItem();
		}
	}

}
