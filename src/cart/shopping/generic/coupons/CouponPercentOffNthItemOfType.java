package cart.shopping.generic.coupons;

import java.util.List;
import java.util.UUID;

import cart.shopping.generic.cart.AbstractCartItem;
import cart.shopping.generic.products.AbstractProduct;

public class CouponPercentOffNthItemOfType extends AbstractCoupon {

	private int threshold;
	private float discountPercent;
	private Class<?> productType;

	private CouponPercentOffNthItemOfType(String title, Class<?> productType, int threshold, float discountPercent) {
		super(title); // TODO Verify null and throw appropriate errors
		this.productType = productType;
		this.threshold = threshold;
		this.discountPercent = discountPercent;
	}

	@Override
	public UUID getCouponID() {

		return UUID.fromString("95180fd3-3c4b-4918-8bc4-8669bb6b6b43");
	}

	// TODO verify getters and setters and remove unused and overprivileged methods.
	private int getThreshold() {
		return threshold;
	}

	private float getDiscountPercent() {
		return discountPercent;
	}

	private Class<?> getProductType() {
		return productType;
	}

	@Override
	public void applyCoupon(AbstractCartItem firstItem, List<AbstractProduct> cartProducts, List<AbstractCoupon> cartCoupons) {

		AbstractCartItem item = firstItem;
		int countProductsOfType = 0;

		while (item != null) {

			try {

				AbstractProduct product = (AbstractProduct) getProductType().cast(item);
				if (++countProductsOfType == getThreshold()) {
					
					float reducedCost = product.getReducedCost();
					reducedCost *= 1 - getDiscountPercent()/100;
					
					product.setReducedCost(reducedCost);
					countProductsOfType = 0;
				}
			} catch (java.lang.ClassCastException ex) {
			}
			item = item.getNextCartItem();
		}
	}
	
	public static AbstractCartItem initialize(String title, Class<?> productType, int threshold, float discountPercent) {
		
		if (title == null || title.trim().length() == 0 || productType == null || threshold < 1 || discountPercent < 0) {
			throw new java.lang.IllegalStateException("Coupon cannot be initialized due to missing inputs");
		}
		
		AbstractCartItem coupon = new CouponPercentOffNthItemOfType(title, productType, threshold, discountPercent);
		return coupon;
	}

}
