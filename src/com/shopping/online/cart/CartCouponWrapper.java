package com.shopping.online.cart;

import com.shopping.online.coupons.AbstractCoupon;

public class CartCouponWrapper implements ICartItem {

	// region: Instance variables
	private AbstractCoupon coupon;
	private ICartItem nextCartItem;
	private ICartItem previousCartItem;

	private CartCouponWrapper(AbstractCoupon coupon) {
		this.setCoupon(coupon);
		this.setNextCartItem(null);
		this.setPreviousCartItem(null);
	}
	
	public static CartCouponWrapper wrap(AbstractCoupon coupon) {
		
		CartCouponWrapper Coupon = new CartCouponWrapper(coupon);
		return Coupon;
	}

	// region: Getters and Setters
	public AbstractCoupon getCoupon() {
		return coupon;
	}

	private void setCoupon(AbstractCoupon coupon) {
		this.coupon = coupon;
	}

	// region: Overridden Methods
	@Override
	public ICartItem getNextCartItem() {

		return this.nextCartItem;
	}

	@Override
	public void setNextCartItem(ICartItem nextCartItem) {

		this.nextCartItem = nextCartItem;
	}

	@Override
	public ICartItem getPreviousCartItem() {

		return this.previousCartItem;
	}

	@Override
	public void setPreviousCartItem(ICartItem previousCartItem) {

		this.previousCartItem = previousCartItem;
	}

	// region: Utility Methods
	public void validateAndApply(Cart targetCart) {
		getCoupon().validateAndApply(targetCart, this);
	}
}
