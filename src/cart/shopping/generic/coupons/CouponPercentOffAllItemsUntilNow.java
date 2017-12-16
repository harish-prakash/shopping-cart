package cart.shopping.generic.coupons;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cart.shopping.generic.cart.AbstractCartItem;
import cart.shopping.generic.products.AbstractProduct;

public class CouponPercentOffAllItemsUntilNow extends AbstractCoupon {
	
	private float discountPercentage;

	// TODO report bug
	public CouponPercentOffAllItemsUntilNow(String title, float discountPercentage) {
		super(title);
		this.discountPercentage = discountPercentage;
	}

	@Override
	public UUID getCouponID() {

		return UUID.fromString("cbfafd99-7095-4ccc-97e9-e530872df046");
	}

	private float getDiscountPercentage() {
		return discountPercentage;
	}

	@Override
	public void applyCoupon(AbstractCartItem firstItem, List<AbstractProduct> cartProducts, List<AbstractCoupon> cartCoupons) {
		
		AbstractCartItem previousItem = getPreviousCartItem();
		
		while(previousItem != null) {
			if (previousItem instanceof AbstractProduct) {
				
				AbstractProduct product = (AbstractProduct) previousItem;
				product.setReducedCost(product.getReducedCost() * (1-(getDiscountPercentage()/100)));
			}
			
			previousItem = previousItem.getPreviousCartItem();
		}
	}
	
	public static AbstractCartItem initialize(float discountPercentage) {
		
		AbstractCartItem coupon = new CouponPercentOffAllItemsUntilNow(String.format("%.0f off everything in cart till now", discountPercentage), discountPercentage);
		return coupon;
	}
	
	public static List<AbstractCartItem> initialize(float discountPercentage, int number) {
		
		ArrayList<AbstractCartItem> coupons = new ArrayList<AbstractCartItem>();
		while(number-- > 0) coupons.add(initialize(discountPercentage));
		return coupons;
	}

}
