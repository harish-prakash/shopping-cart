package cart.shopping.generic.coupons;

import java.util.UUID;

import cart.shopping.generic.cart.Cart;
import cart.shopping.generic.cart.CartProductWrapper;
import cart.shopping.generic.cart.ICartItem;

public class CouponPercentOffNthItemOfType extends AbstractCoupon {

	// region: Instance Variables
	private Class<?> productType;
	private float discountPercent;
	private int threshold;

	// region: Class Initializers
	private CouponPercentOffNthItemOfType(String title, Class<?> productType, float discountPercent, int threshold, boolean allowReuse) {
		super(title);
		setProductType(productType);
		setDiscountPercent(discountPercent);
		setThreshold(threshold);
		setAllowMultiUse(allowReuse);
	}
	
	public static AbstractCoupon instance(String title, Class<?> productType, float discountPercent, int threshold, boolean allowReuse) {
		
		CouponPercentOffNthItemOfType coupon = new CouponPercentOffNthItemOfType(title, productType, discountPercent, threshold, allowReuse);
		return coupon;
	}

	// region: Getters and Setters
	private Class<?> getProductType() {
		return productType;
	}

	private void setProductType(Class<?> productType) {
		this.productType = productType;
	}

	private float getDiscountPercent() {
		return discountPercent;
	}

	private void setDiscountPercent(float discountPercent) {
		this.discountPercent = discountPercent;
	}

	private int getThreshold() {
		return threshold;
	}

	private void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	// region: Overridden Methods
	@Override
	public UUID getCouponID() {

		return UUID.fromString("a32acbc1-40e2-4b22-8993-bd2026831ed1");
	}

	@Override
	public void applyCoupon(Cart targetCart, ICartItem cartCouponInstance) {

		ICartItem cartItem = targetCart.getFirstItem();
		int countProductTypeOccurance = 0;

		while (cartItem != null) {

			try {
				if (cartItem instanceof CartProductWrapper) {

					CartProductWrapper Product = (CartProductWrapper) cartItem;
					getProductType().cast(Product.getProduct());

					if (++countProductTypeOccurance >= getThreshold()) {

						countProductTypeOccurance = 0;
						float reducedCost = Product.getReducedCost();

						reducedCost *= 1 - getDiscountPercent() / 100;
						Product.setReducedCost(reducedCost);
						Product.tagAppliedCoupon(this);
					}
				}
			} catch (java.lang.ClassCastException ex) {
			}

			cartItem = cartItem.getNextCartItem();
		}
	}

}
