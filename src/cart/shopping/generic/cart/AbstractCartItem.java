package cart.shopping.generic.cart;

public abstract class AbstractCartItem {

	private AbstractCartItem previousCartItem;
	private AbstractCartItem nextCartItem;
	
	protected AbstractCartItem() {
		previousCartItem = null;
		nextCartItem = null;
	}

	public final AbstractCartItem getNextCartItem() {
		return nextCartItem;
	}

	public final void setNextCartItem(AbstractCartItem nextCartItem) {
		this.nextCartItem = nextCartItem;
	}

	public final AbstractCartItem getPreviousCartItem() {
		return previousCartItem;
	}

	public final void setPreviousCartItem(AbstractCartItem previousCartItem) {
		this.previousCartItem = previousCartItem;
	}
}
