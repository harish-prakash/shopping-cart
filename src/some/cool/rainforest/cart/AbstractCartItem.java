package some.cool.rainforest.cart;

/**
 * @author Harish Prakash (harry)
 *
 */

//TODO Add comments for javadoc
public abstract class AbstractCartItem {

	private AbstractCartItem _previousCartItem;
	private AbstractCartItem _nextCartItem;
	
	protected AbstractCartItem() {
		_previousCartItem = null;
		_nextCartItem = null;
	}

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
