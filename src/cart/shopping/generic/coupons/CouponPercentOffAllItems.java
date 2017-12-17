package cart.shopping.generic.coupons;

import java.util.UUID;

import cart.shopping.generic.cart.Cart;
import cart.shopping.generic.cart.CartProductWrapper;
import cart.shopping.generic.cart.ICartItem;

public class CouponPercentOffAllItems extends AbstractCoupon {

	//region: Instance Variables
	private float discountPercent;
	
	private CouponPercentOffAllItems(String title, float discountPercent, boolean allowMultipleUse) {
		super(title);
		setDiscountPercent(discountPercent);
		setAllowMultiUse(allowMultipleUse);
	}
	
	public static AbstractCoupon instance(String title, float discountPercent, boolean allowMultipleUse) {
		
		CouponPercentOffAllItems coupon = new CouponPercentOffAllItems(title, discountPercent, allowMultipleUse);
		return coupon;
	}

	//region: Getters and Setters
	@Override
	public UUID getCouponID() {

		return UUID.fromString("7fe46c94-3456-4acc-8b1c-dd4ab34ff48f");
	}

	private float getDiscountPercent() {
		return discountPercent;
	}

	private void setDiscountPercent(float discountPercent) {
		this.discountPercent = discountPercent;
	}

	@Override
	public void applyCoupon(Cart targetCart, ICartItem cartCouponInstance) {
		
		ICartItem cartItem = targetCart.getFirstItem();
		
		while(cartItem != null) {
			
			if (cartItem instanceof CartProductWrapper) {
				
				CartProductWrapper Product = (CartProductWrapper) cartItem;
				float reducedCost = Product.getReducedCost();
				
				reducedCost *= 1 - getDiscountPercent()/100;
				Product.setReducedCost(reducedCost);
			}

			cartItem = cartItem.getNextCartItem();
		}
	}

}
