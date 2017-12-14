/**
 * 
 */
package some.cool.rainforest.cart;

/**
 * @author harry
 *
 */
public interface ICartItem {

	public ICartItem getNextCartItem();
	public void setNextCartItem(ICartItem nextCartItem);
	public ICartItem getPreviousCartItem();
	public void setPreviousCartItem(ICartItem previousCartItem);
}
