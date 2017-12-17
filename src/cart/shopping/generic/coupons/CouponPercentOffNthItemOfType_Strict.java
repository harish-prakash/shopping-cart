package cart.shopping.generic.coupons;

import java.util.UUID;

import cart.shopping.generic.cart.Cart;
import cart.shopping.generic.cart.ICartItem;

public class CouponPercentOffNthItemOfType_Strict extends AbstractCoupon {

	// region: Instance Variables
	// region: Class Initializers
	private CouponPercentOffNthItemOfType_Strict(String title) {
		super(title);
		// TODO Report bug
	}
	
	public static AbstractCoupon instance(String title) {
		
		CouponPercentOffNthItemOfType_Strict coupon = new CouponPercentOffNthItemOfType_Strict(title);
		return coupon;
	}

	// region: Getters and Setters
	// region: Overridden Methods
	@Override
	public UUID getCouponID() {

		return UUID.fromString("19b494d8-e37a-11e7-80c1-9a214cf093ae");
	}

	@Override
	public void applyCoupon(Cart targetCart, ICartItem cartCouponInstance) {
		// TODO Auto-generated method stub

	}

}
