package cart.shopping.generic.coupons;

import java.util.List;
import java.util.UUID;

import cart.shopping.generic.cart.AbstractCartItem;
import cart.shopping.generic.products.AbstractProduct;

/**
 * @author Harish Prakash (harry)
 *
 */

//TODO Add comments for javadoc
public abstract class AbstractCoupon extends AbstractCartItem {
	
	private UUID couponID;
	private String title;
	private String description;
	
	protected AbstractCoupon(String title, String description) {
		
		this.couponID = UUID.randomUUID();
		this.title = title;
		this.description = description;
	}
	
	public UUID getCouponID() {
		return couponID;
	}

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

	public abstract String applyCoupon(AbstractCartItem firstItem, List<AbstractProduct> cartProducts, List<AbstractCoupon> cartCoupons);
	// TODO Implement coupon types

}
