package com.shopping.online.coupons;

import java.util.UUID;

import com.shopping.online.cart.Cart;
import com.shopping.online.cart.CartProductWrapper;
import com.shopping.online.cart.ICartItem;

public class CouponPercentOffNextItem extends AbstractCoupon {
	
	// region: Instance Variables
	private float discountPercent;

	// region: Class Initializers
	private CouponPercentOffNextItem(String title, float discountPercent) {
		super(title);
		setDiscountPercent(discountPercent);
	}
	
	public static AbstractCoupon instance(String title, float discountPercent) {
		
		CouponPercentOffNextItem coupon = new CouponPercentOffNextItem(title, discountPercent);
		return coupon;
	}
	
	// region: Getters and Setters	
	private float getDiscountPercent() {
		return discountPercent;
	}

	private void setDiscountPercent(float discountPercent) {
		this.discountPercent = discountPercent;
	}

	// region: Overridden Methods
	@Override
	public UUID getCouponID() {

		return UUID.fromString("19b49924-e37a-11e7-80c1-9a214cf093ae");
	}

	@Override
	public void applyCoupon(Cart targetCart, ICartItem cartCouponInstance) {
		
		ICartItem cartItem = cartCouponInstance;
		while(cartItem.getNextCartItem() != null) {
			if (cartItem.getNextCartItem() instanceof CartProductWrapper) {
				
				CartProductWrapper Product = (CartProductWrapper) cartItem.getNextCartItem();
				float reducedCost = Product.getReducedCost();
				
				reducedCost *= 1 - getDiscountPercent()/100;
				Product.setReducedCost(reducedCost);
				Product.tagAppliedCoupon(this);
				break;
			}
			
			else {
				cartItem = cartItem.getNextCartItem();
			}
		}
	}

}
