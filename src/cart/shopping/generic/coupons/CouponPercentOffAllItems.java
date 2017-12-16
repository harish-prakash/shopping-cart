package cart.shopping.generic.coupons;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cart.shopping.generic.cart.AbstractCartItem;
import cart.shopping.generic.products.AbstractProduct;

public class CouponPercentOffAllItems extends AbstractCoupon {
	
	private float discountPercentage;

	private CouponPercentOffAllItems(String title, float discountPercentage) {
		super(title);
		setAllowMultiUse(true);
		this.discountPercentage = discountPercentage;
	}

	@Override
	public UUID getCouponID() {
		return UUID.fromString("90c5f4b2-b9fc-4052-a42f-53bc4b53f8de");
	}

	public float getDiscountPercentage() {
		return discountPercentage;
	}

	@Override
	public void applyCoupon(AbstractCartItem firstItem, List<AbstractProduct> cartProducts, List<AbstractCoupon> cartCoupons) {
		
		for (AbstractProduct product : cartProducts) {
			product.setReducedCost(product.getReducedCost() * (1-(getDiscountPercentage()/100)));
		}
	}
	
	public static AbstractCartItem initialize(float percent) {
		AbstractCartItem coupon = new CouponPercentOffAllItems(String.format("%.0f%% off your cart", percent), percent);
		return coupon;
	}
	
	public static List<AbstractCartItem> initialize(float percent, int number) {
		ArrayList<AbstractCartItem> coupons = new ArrayList<AbstractCartItem>();
		while(number-- > 0) coupons.add(initialize(percent));
		return coupons;
	}

}
