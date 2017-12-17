package cart.shopping.generic.coupons;

import java.util.UUID;

import cart.shopping.generic.cart.Cart;
import cart.shopping.generic.cart.ICartItem;

public class CouponPercentOffNthItemOfType_Strict extends AbstractCoupon {

	public CouponPercentOffNthItemOfType_Strict(String title) {
		super(title);
		// TODO Report bug
	}

	@Override
	public UUID getCouponID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void applyCoupon(Cart targetCart, ICartItem cartCouponInstance) {
		// TODO Auto-generated method stub

	}

}
