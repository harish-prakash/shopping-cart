package some.cool.rainforest.cart;

import java.util.ArrayList;
import java.util.List;

import some.cool.rainforest.coupons.AbstractCoupon;
import some.cool.rainforest.products.AbstractProduct;

//TODO Add comments for javadoc
public class Cart {

	private AbstractCartItem _firstItem;
	private AbstractCartItem _lastItem;

	private ArrayList<AbstractProduct> _cartProducts;
	private ArrayList<AbstractCoupon> _cartCoupons;

	private Cart() {
		initialize();
	}

	private void initialize() {

		_firstItem = null;
		_lastItem = null;

		_cartProducts = new ArrayList<AbstractProduct>();
		_cartCoupons = new ArrayList<AbstractCoupon>();
	}

	public AbstractCartItem getFirstItem() {
		return _firstItem;
	}

	private void setFirstItem(AbstractCartItem firstItem) {
		this._firstItem = firstItem;
	}

	private AbstractCartItem getLastItem() {
		return _lastItem;
	}

	private void setLastItem(AbstractCartItem lastItem) {
		this._lastItem = lastItem;
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
		_cartProducts.add(product);
	}

	private void addCoupon(AbstractCoupon coupon) {
		_cartCoupons.add(coupon);
	}

	public List<AbstractProduct> getProducts() {

		for (AbstractProduct product : _cartProducts) {
			product.resetReducedCostAndCoupons();
		}

		for (AbstractCoupon coupon : getCoupons()) {
			coupon.applyCoupon(getFirstItem());
		}

		return _cartProducts;
	}

	public List<AbstractCoupon> getCoupons() {
		return _cartCoupons;
	}

	public float getCartTotal() {

		float total = 0;

		for (AbstractProduct product : getProducts()) {
			total += product.getReducedCost();
		}

		return total;
	}

}
