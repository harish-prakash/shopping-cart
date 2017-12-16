package cart.shopping.generic.coupons;

import java.util.List;
import java.util.UUID;

import cart.shopping.generic.cart.AbstractCartItem;
import cart.shopping.generic.products.AbstractProduct;

public abstract class AbstractCoupon extends AbstractCartItem {
	
	private String title;
	private String description;
	private boolean reusable;
	
	protected AbstractCoupon(String title, String description) {

		this.title = title;
		this.description = description;
	}
	
	public abstract UUID getCouponID();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isReusable() {
		return reusable;
	}

	public void setReusable(boolean reusable) {
		this.reusable = reusable;
	}

	public boolean isEqual(AbstractCoupon coupon) {
		return getCouponID().compareTo(coupon.getCouponID()) == 0;
	}

	public abstract void applyCoupon(AbstractCartItem firstItem, List<AbstractProduct> cartProducts, List<AbstractCoupon> cartCoupons);

}
