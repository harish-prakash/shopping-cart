package cart.shopping.generic.coupons;

import java.util.UUID;

import cart.shopping.generic.cart.Cart;
import cart.shopping.generic.cart.ICartItem;

public class CouponPercentOffNthItemOfType_Strict extends AbstractCoupon {

	// region: Instance Variables
	// region: Class Initializers
	private CouponPercentOffNthItemOfType_Strict(String title) {
		super(title);
		// TODO Report Bug
	}
	
	public static AbstractCoupon instance(String title) {
		
		CouponPercentOffNthItemOfType_Strict coupon = new CouponPercentOffNthItemOfType_Strict(title);
		return coupon;
	}

	// region: Getters and Setters
	// region: Overridden Methods
	@Override
	public UUID getCouponID() {

		return UUID.fromString("cbfafd99-7095-4ccc-97e9-e530872df046");
	}

	@Override
	public void applyCoupon(Cart targetCart, ICartItem cartCouponInstance) {
		// TODO Auto-generated method stub

	}

}
