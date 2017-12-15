/**
 * 
 */
package some.cool.rainforest.cart;

/**
 * @author harry
 *
 */
public abstract class AbstractCartItem {

	private AbstractCartItem _previousCartItem;
	private AbstractCartItem _nextCartItem;

	public final AbstractCartItem getNextCartItem() {
		return _nextCartItem;
	}

	public final void setNextCartItem(AbstractCartItem nextCartItem) {
		this._nextCartItem = nextCartItem;
	}

	public final AbstractCartItem getPreviousCartItem() {
		return _previousCartItem;
	}

	public final void setPreviousCartItem(AbstractCartItem previousCartItem) {
		this._previousCartItem = previousCartItem;
	}
}
