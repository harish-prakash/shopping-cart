package cart.shopping.generic.coupons;

import java.util.List;
import java.util.UUID;

import cart.shopping.generic.cart.AbstractCartItem;
import cart.shopping.generic.products.AbstractProduct;
import cart.shopping.generic.products.ProductJeans;

public class CouponJeansThreeForTwo extends AbstractCoupon {

	private CouponJeansThreeForTwo(String title) {
		super(title);
	}

	@Override
	public UUID getCouponID() {

		return UUID.fromString("d7067377-966d-46be-a8df-619e15e91e13");
	}

	@Override
	public void applyCoupon(AbstractCartItem firstItem, List<AbstractProduct> cartProducts, List<AbstractCoupon> cartCoupons) {

		AbstractCartItem item = firstItem;
		int countValidProductsNotCredited = 0;

		while (item != null) {

			if (item instanceof ProductJeans) {

				if (countValidProductsNotCredited == 2) {
					countValidProductsNotCredited = 0;
					((ProductJeans) item).setReducedCost(0);
					((ProductJeans) item).addAppliedCoupon(this);
				}

				else {
					countValidProductsNotCredited++;
				}
			}

			item = item.getNextCartItem();
		}
	}

	public static AbstractCartItem initialize() {

		CouponJeansThreeForTwo coupon = new CouponJeansThreeForTwo("Buy two Jeans and get the third free");
		return coupon;
	}
}
