package cart.shopping.generic.coupons;

import java.util.UUID;

import cart.shopping.generic.cart.Cart;
import cart.shopping.generic.cart.ICartItem;

public class CouponPercentOffNextItem extends AbstractCoupon {

	public CouponPercentOffNextItem(String title) {
		super(title);
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
