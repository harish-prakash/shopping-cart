package cart.shopping.generic.coupons;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cart.shopping.generic.cart.AbstractCartItem;
import cart.shopping.generic.products.AbstractProduct;

public class CouponDollarsOffNthProductType extends AbstractCoupon {

	private Class<?> productType;
	private float discountDollars;
	private int threshold;

	// TODO report bug
	public CouponDollarsOffNthProductType(String title, Class<?> productType, float discountDollars, int threshold) {
		super(title);
		setAllowMultiUse(true);
		this.productType = productType;
		this.discountDollars = discountDollars;
		this.threshold = threshold;
	}

	@Override
	public UUID getCouponID() {
		return UUID.fromString("601a4c2d-1ecd-44b0-a223-cc10a4507d8d");
	}

	public Class<?> getProductType() {
		return productType;
	}

	public float getDiscountDollars() {
		return discountDollars;
	}

	public int getThreshold() {
		return threshold;
	}

	@Override
	public void applyCoupon(AbstractCartItem firstItem, List<AbstractProduct> cartProducts, List<AbstractCoupon> cartCoupons) {

		AbstractCartItem cartItem = firstItem;
		int countNumberOfProductOccurence = 0;

		while (cartItem != null) {
			try {
				AbstractProduct product = (AbstractProduct) getProductType().cast(cartItem);

				if (++countNumberOfProductOccurence == getThreshold()) {
					product.setReducedCost(product.getReducedCost() - getDiscountDollars());
					break;
				}
			} catch (java.lang.ClassCastException ex) {
				// Leave the threshold unaltered
			}

			cartItem = cartItem.getNextCartItem();
		}
	}

	public static AbstractCartItem initialize(Class<?> productType, float discountDollars, int threshold) {

		// TODO fill title
		AbstractCartItem coupon = new CouponDollarsOffNthProductType(String.format("WIP", discountDollars, threshold, productType.getName()), productType, discountDollars, threshold);
		return coupon;
	}

	public static List<AbstractCartItem> initialize(Class<?> productType, float discountDollars, int threshold, int number) {

		ArrayList<AbstractCartItem> coupons = new ArrayList<AbstractCartItem>();
		while (number-- > 0)
			coupons.add(initialize(productType, discountDollars, threshold));
		return coupons;
	}

}
