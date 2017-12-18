package com.shopping.online.coupons;

import java.util.UUID;

import com.shopping.online.cart.Cart;
import com.shopping.online.cart.CartCouponWrapper;
import com.shopping.online.cart.ICartItem;
import com.shopping.online.exceptions.ShoppingCartException;

public abstract class AbstractCoupon {

	private String title;
	private boolean allowMultiUse;
	
	//region: Class Initializers
	protected AbstractCoupon(String title) {

		this.title = title;
	}
	
	//region: Getters and Setters 
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean getAllowMultiUse() {
		return allowMultiUse;
	}

	public void setAllowMultiUse(boolean reusable) {
		this.allowMultiUse = reusable;
	}

	//region: Utility methods
	public final boolean isEqual(AbstractCoupon coupon) {
		return getCouponID().compareTo(coupon.getCouponID()) == 0; // TODO consider "final"ing
	}

	public final void validateAndApply(Cart targetCart, ICartItem cartCouponInstance) {

		// Validate coupon re-use
		if (!getAllowMultiUse()) {

			int countCouponUse = 0;
			for (CartCouponWrapper couponInCart : targetCart.getCoupons()) {

				if (this.isEqual(couponInCart.getCoupon()))
					countCouponUse++;
			}

			if (countCouponUse > 1) {
				throw new ShoppingCartException(String.format("\"%s\" coupon cannot be used more than once on the same cart", getTitle()));
			}
		}

		applyCoupon(targetCart, cartCouponInstance);
	}

	//region: Abstract methods
	public abstract UUID getCouponID();

	public abstract void applyCoupon(Cart targetCart, ICartItem cartCouponInstance);

}
