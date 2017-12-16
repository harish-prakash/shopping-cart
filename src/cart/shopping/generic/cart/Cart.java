package cart.shopping.generic.cart;

import java.util.ArrayList;
import java.util.List;

import cart.shopping.generic.coupons.AbstractCoupon;
import cart.shopping.generic.products.AbstractProduct;

//TODO Add comments for javadoc
public class Cart {

	private AbstractCartItem firstItem;
	private AbstractCartItem lastItem;

	private ArrayList<AbstractProduct> cartProducts;
	private ArrayList<AbstractCoupon> cartCoupons;

	private Cart() {
		initialize();
	}

	private void initialize() {

		this.firstItem = null;
		this.lastItem = null;

		this.cartProducts = new ArrayList<AbstractProduct>();
		this.cartCoupons = new ArrayList<AbstractCoupon>();
	}

	public AbstractCartItem getFirstItem() {
		return firstItem;
	}

	private void setFirstItem(AbstractCartItem firstItem) {
		this.firstItem = firstItem;
	}

	private AbstractCartItem getLastItem() {
		return lastItem;
	}

	private void setLastItem(AbstractCartItem lastItem) {
		this.lastItem = lastItem;
	}

	public void addCartItem(AbstractCartItem item) {
		if (getFirstItem() == null) {
			setFirstItem(item);
			setLastItem(item);
		}

		else {
			getLastItem().setNextCartItem(item);
			item.setPreviousCartItem(getLastItem());
			setLastItem(item);

			if (item instanceof AbstractProduct)
				addProduct((AbstractProduct) item);
			else // Consider using else if or just if to accommodate other types in the future
				addCoupon((AbstractCoupon) item);
		}
	}

	private void addProduct(AbstractProduct product) {
		this.cartProducts.add(product);
	}

	private void addCoupon(AbstractCoupon coupon) {
		this.cartCoupons.add(coupon);
	}

	// TODO consider potential deadlock
	public List<AbstractProduct> getProducts() {

		for (AbstractProduct product : cartProducts) {
			product.resetReducedCostAndCoupons();
		}

		for (AbstractCoupon coupon : getCoupons()) {
			coupon.applyCoupon(getFirstItem(), cartProducts, getCoupons());
		}

		return cartProducts;
	}

	public List<AbstractCoupon> getCoupons() {
		return cartCoupons;
	}

	public float getCartTotal() {

		float total = 0;

		for (AbstractProduct product : getProducts()) {
			total += product.getReducedCost();
		}

		return total;
	}

}
