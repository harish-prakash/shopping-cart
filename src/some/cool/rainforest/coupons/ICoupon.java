/**
 * 
 */
package some.cool.rainforest.coupons;

import some.cool.rainforest.cart.CartLedger;
import some.cool.rainforest.cart.ICartItem;

/**
 * @author harry
 *
 */
public interface ICoupon extends ICartItem{

	public String applyCoupon(CartLedger ledger);
}
