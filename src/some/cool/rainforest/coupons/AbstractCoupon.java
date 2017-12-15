package some.cool.rainforest.coupons;

import some.cool.rainforest.cart.AbstractCartItem;

/**
 * @author Harish Prakash (harry)
 *
 */

//TODO Add comments for javadoc
public abstract class AbstractCoupon extends AbstractCartItem {
	
	protected AbstractCoupon() {}
	
	public abstract String applyCoupon(AbstractCartItem firstItem);

}
