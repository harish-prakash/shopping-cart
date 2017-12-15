/**
 * 
 */
package some.cool.rainforest.coupons;

import some.cool.rainforest.cart.AbstractCartItem;

/**
 * @author harry
 *
 */
public abstract class AbstractCoupon extends AbstractCartItem {

	/**
	 * 
	 */
	
	public abstract String applyCoupon(AbstractCartItem firstItem);

}
