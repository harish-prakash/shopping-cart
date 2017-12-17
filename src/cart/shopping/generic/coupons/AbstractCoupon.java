package cart.shopping.generic.coupons;

import java.util.List;
import java.util.UUID;

import cart.shopping.generic.cart.AbstractCartItem;
import cart.shopping.generic.exceptions.ShoppingCartException;
import cart.shopping.generic.products.AbstractProduct;

public abstract class AbstractCoupon extends AbstractCartItem {

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

	public final void validateAndApplyCoupon(AbstractCartItem firstItem, List<AbstractProduct> cartProducts, List<AbstractCoupon> cartCoupons) {

		// Validate coupon re-use
		if (!getAllowMultiUse()) {

			int countCouponUse = 0;
			for (AbstractCoupon coupon : cartCoupons) {

				if (isEqual(coupon))
					countCouponUse++;
			}

			if (countCouponUse > 1) {
				throw new ShoppingCartException("Jeans Three for two coupon cannot be used more than once");
			}
		}

		applyCoupon(firstItem, cartProducts, cartCoupons);
	}

	//region: Abstract methods
	public abstract UUID getCouponID();

	public abstract void applyCoupon(AbstractCartItem firstItem, List<AbstractProduct> cartProducts, List<AbstractCoupon> cartCoupons);

}
