package cart.shopping.generic.cart;

import java.util.ArrayList;
import java.util.List;

import cart.shopping.generic.coupons.AbstractCoupon;
import cart.shopping.generic.products.AbstractProduct;

public class CartProductWrapper implements ICartItem {

	private ICartItem previousCartItem;
	private ICartItem nextCartItem;

	private AbstractProduct product;
	private float reducedCost;
	private ArrayList<AbstractCoupon> appliedCoupons;

	private CartProductWrapper(AbstractProduct product) {
		
		setProduct(product);
		setReducedCost(getProduct().getCost());
		setPreviousCartItem(null);
		setNextCartItem(null);
	}

	public static CartProductWrapper wrap(AbstractProduct product) {
		CartProductWrapper wrapper = new CartProductWrapper(product);
		return wrapper;
	}
	
	// region: Getters and setters
	public float getReducedCost() {
		return reducedCost;
	}

	public void setReducedCost(float reducedCost) {
		this.reducedCost = reducedCost;
	}

	public AbstractProduct getProduct() {
		return product;
	}

	public void setProduct(AbstractProduct product) {
		this.product = product;
	}

	public List<AbstractCoupon> getAppliedCoupons() {
		
		if (this.appliedCoupons == null) {
			this.appliedCoupons = new ArrayList<AbstractCoupon>();
		}
		
		return this.appliedCoupons;
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
	public void tagAppliedCoupon(AbstractCoupon coupon) {
		if (this.appliedCoupons == null) {
			this.appliedCoupons = new ArrayList<AbstractCoupon>();
		}

		this.appliedCoupons.add(coupon);
	}
	
	public void resetDiscounts() {
		
		setReducedCost(getProduct().getCost());
		if (appliedCoupons != null) appliedCoupons.clear();
	}
}
