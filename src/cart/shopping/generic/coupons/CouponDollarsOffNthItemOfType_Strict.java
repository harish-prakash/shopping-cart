package cart.shopping.generic.coupons;

import java.util.UUID;

import cart.shopping.generic.cart.Cart;
import cart.shopping.generic.cart.CartProductWrapper;
import cart.shopping.generic.cart.ICartItem;

public class CouponDollarsOffNthItemOfType_Strict extends AbstractCoupon {

	// region: Instance Variables
	private float discountDollars;
	private Class<?> productType;
	private int threshold;
	
	// region: Class Initializers
	private CouponDollarsOffNthItemOfType_Strict(String title, Class<?> productType, int threshold, float discountDollars) {
		super(title);
		setProductType(productType);
		setThreshold(threshold);
		setDiscountDollars(discountDollars);
		setAllowMultiUse(true); // TODO Report Bug
	}
	
	public static AbstractCoupon instance(String title, Class<?> productType, int threshold, float discountDollars) {
		
		CouponDollarsOffNthItemOfType_Strict coupon = new CouponDollarsOffNthItemOfType_Strict(title, productType, threshold, discountDollars);
		return coupon;
	}
	// region: Getters and Setters
	
	private float getDiscountDollars() {
		return discountDollars;
	}

	private void setDiscountDollars(float discountDollars) {
		this.discountDollars = discountDollars;
	}

	private Class<?> getProductType() {
		return productType;
	}

	private void setProductType(Class<?> productType) {
		this.productType = productType;
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

		return UUID.fromString("cbfafd99-7095-4ccc-97e9-e530872df046");
	}

	@Override
	public void applyCoupon(Cart targetCart, ICartItem cartCouponInstance) {
		
		ICartItem cartItem = targetCart.getFirstItem();
		int countProductTypeOccurance = 0;
		
		while(cartItem != null) {
			
			try {

				if (cartItem instanceof CartProductWrapper) {
					
					CartProductWrapper Product = (CartProductWrapper) cartItem;
					getProductType().cast(Product.getProduct());
					
					countProductTypeOccurance += 1;
					
					if (countProductTypeOccurance >= getThreshold()) {
						
						float reducedCost = Product.getReducedCost();
						reducedCost -= getDiscountDollars();
						
						Product.setReducedCost(reducedCost);
						Product.tagAppliedCoupon(this);
						break;
					}
				}
			} catch (java.lang.ClassCastException ex) {}
			
			cartItem = cartItem.getNextCartItem();
		}
	}

}
