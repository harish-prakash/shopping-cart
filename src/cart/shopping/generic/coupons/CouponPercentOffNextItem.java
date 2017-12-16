package cart.shopping.generic.coupons;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cart.shopping.generic.cart.AbstractCartItem;
import cart.shopping.generic.products.AbstractProduct;

public class CouponPercentOffNextItem extends AbstractCoupon {
	
	private float discountPercentage;

	private CouponPercentOffNextItem(String title, float discountPercentage) {
		super(title);
		this.discountPercentage = discountPercentage;
	}

	@Override
	public UUID getCouponID() {
		return UUID.fromString("a0a08210-be20-4d08-b1b5-3905f3ba46d0");
	}

	public float getDiscountPercentage() {
		return discountPercentage;
	}

	@Override
	public void applyCoupon(AbstractCartItem firstItem, List<AbstractProduct> cartProducts, List<AbstractCoupon> cartCoupons) {
		
		AbstractCartItem cartItem = getNextCartItem();
		
		while (cartItem != null) {
			if (cartItem instanceof AbstractProduct) {
				AbstractProduct product = (AbstractProduct) cartItem;
				product.setReducedCost(product.getReducedCost() * (1-(getDiscountPercentage()/100)));
				break;
			}
			
			else {
				cartItem = cartItem.getNextCartItem();
			}
		}
	}

	public static AbstractCartItem initialize(float percent) {
		
		AbstractCartItem coupon = new CouponPercentOffNextItem(String.format("%.0f%% off next item", percent), percent);
		return coupon;
	}
	
	public static List<AbstractCartItem> initialize(float percent, int number) {
		
		ArrayList<AbstractCartItem> coupons = new ArrayList<AbstractCartItem>();
		while(number-- > 0) coupons.add(initialize(percent));
		return coupons;
	}
}
