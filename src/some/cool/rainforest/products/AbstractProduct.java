/**
 * 
 */
package some.cool.rainforest.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import some.cool.rainforest.cart.ICartItem;
import some.cool.rainforest.coupons.ICoupon;

/**
 * @author harry
 *
 */
public abstract class AbstractProduct implements ICartItem {
	
	private float _cost;
	private String _title;
	private String _description;
	private String _manufacturer;
	private HashMap<String, String> _otherInformation;
	
	private float _reducedCost;
	private ArrayList<ICoupon> _appliedCoupons;
	
	private ICartItem _previousCartItem;
	private ICartItem _nextCartItem;
	
	protected AbstractProduct(float cost, String title) {
		this._cost = cost;
		this._reducedCost = cost;
		this._title = title;
		
		_otherInformation = new HashMap<String, String>();
		_appliedCoupons = new ArrayList<ICoupon>();
	}
	
	public float getCost() {
		return _cost;
	}
	
	public String getTitle() {
		return _title;
	}
	
	public String getDescription() {
		return _description;
	}
	
	public void setDescription(String description) {
		this._description = description;
	}

	/**
	 * @return the _manufacturer
	 */
	public String getManufacturer() {
		return _manufacturer;
	}

	/**
	 * @param manufacturer the _manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this._manufacturer = manufacturer;
	}
	
	public String setInformation(String label, String details) {
		return _otherInformation.put(label, details);
	}
	
	public String getInformation(String label) {
		return _otherInformation.get(label);
	}
	
	public float getReducedCost() {
		return _reducedCost;
	}
	
	public void setReducedCost(float cost) {
		this._reducedCost = cost;
	}
	
	public void resetReducedCost() {
		this._reducedCost = this._cost;
		this._appliedCoupons.clear();
	}
	
	public void addAppliedCoupon(ICoupon coupon) {
		this._appliedCoupons.add(coupon);
	}
	
	public List<ICoupon> getAppliedCoupons() {
		return this._appliedCoupons;
	}
	
	public ICartItem getNextCartItem() {
		return _nextCartItem;
	}
	
	public void setNextCartItem(ICartItem nextCartItem) {
		this._nextCartItem = nextCartItem;
	}
	
	public ICartItem getPreviousCartItem() {
		return _previousCartItem;
	}
	
	public void setPreviousCartItem(ICartItem previousCartItem) {
		this._previousCartItem = previousCartItem;
	}
}
