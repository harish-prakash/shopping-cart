package cart.shopping.generic.coupons;

import java.util.UUID;

import cart.shopping.generic.cart.Cart;
import cart.shopping.generic.cart.CartProductWrapper;
import cart.shopping.generic.cart.ICartItem;

public class CouponPercentOffPreviousItems extends AbstractCoupon {

	// region: Instance Variables
	private float discountPercent;
	
	// region: Class Initializers
	private CouponPercentOffPreviousItems(String title, float discountPercent) {
		super(title);
		setDiscountPercent(discountPercent);
		// TODO Report bug
	}
	
	public static AbstractCoupon instance(String title, float discountPercent) {
		
		CouponPercentOffPreviousItems coupon = new CouponPercentOffPreviousItems(title, discountPercent);
		return coupon;
	}

	// region: Getters and Setters	
	private float getDiscountPercent() {
		return discountPercent;
	}

	private void setDiscountPercent(float discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	// region: Overridden Methods
	@Override
	public UUID getCouponID() {

		return UUID.fromString("19b494d8-e37a-11e7-80c1-9a214cf093ae");
	}

	@Override
	public void applyCoupon(Cart targetCart, ICartItem cartCouponInstance) {
		
		ICartItem cartItem = cartCouponInstance;
		while (cartItem != null) {
			
			if (cartItem instanceof CartProductWrapper) {
				
				CartProductWrapper Product = (CartProductWrapper) cartItem;
				float reducedCost = Product.getReducedCost();
				
				reducedCost *= 1 - getDiscountPercent()/100;
				Product.setReducedCost(reducedCost);
				Product.tagAppliedCoupon(this);
			}

			cartItem = cartItem.getPreviousCartItem();
		}
	}

}
