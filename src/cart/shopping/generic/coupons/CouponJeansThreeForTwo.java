package cart.shopping.generic.coupons;

import java.util.List;
import java.util.UUID;

import cart.shopping.generic.cart.AbstractCartItem;
import cart.shopping.generic.exceptions.ShoppingCartException;
import cart.shopping.generic.products.AbstractProduct;
import cart.shopping.generic.products.ProductJeans;

public class CouponJeansThreeForTwo extends AbstractCoupon {

	private CouponJeansThreeForTwo(String title, String description) {
		super(title, description);
	}

	@Override
	public UUID getCouponID() {

		return UUID.fromString("d7067377-966d-46be-a8df-619e15e91e13");
	}

	@Override
	public void applyCoupon(AbstractCartItem firstItem, List<AbstractProduct> cartProducts,
			List<AbstractCoupon> cartCoupons) {

		AbstractCartItem item = firstItem;
		int countValidProductsNotCredited = 0;

		if (!isReusable()) {

			int countCouponUse = 0;
			for (AbstractCoupon coupon : cartCoupons) {

				if (coupon instanceof CouponJeansThreeForTwo)
					countCouponUse++;
			}

			if (countCouponUse > 1) {
				throw new ShoppingCartException("Jeans Three for two coupon cannot be used more than once");
			}
		}

		while (item != null) {

			if (item instanceof ProductJeans) {

				if (countValidProductsNotCredited == 2) {
					countValidProductsNotCredited = 0;
					((ProductJeans) item).setReducedCost(0);
				}

				else {
					countValidProductsNotCredited++;
				}
			}

			item = item.getNextCartItem();
		}
	}

	public static AbstractCartItem initialize() {

		CouponJeansThreeForTwo coupon = new CouponJeansThreeForTwo("Buy two Jeans and get the third free",
				"Buy two Jeans and get the third free");
		coupon.setReusable(false);
		return coupon;
	}
}
