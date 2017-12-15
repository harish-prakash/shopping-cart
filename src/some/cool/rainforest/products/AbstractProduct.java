/**
 * 
 */
package some.cool.rainforest.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import some.cool.rainforest.cart.AbstractCartItem;
import some.cool.rainforest.coupons.AbstractCoupon;

/**
 * @author harry
 *
 */
public abstract class AbstractProduct extends AbstractCartItem {
	
	protected float _cost;
	protected String _title;
	protected String _description;
	protected String _manufacturer;
	protected HashMap<String, String> _otherInformation;
	
	private float _reducedCost;
	private ArrayList<AbstractCoupon> _appliedCoupons;
	
	protected AbstractProduct(float cost, String title) {
		
		this.initialize(cost, title);
	}
	
	private void initialize(float cost, String title) {
		
		this._cost = cost;
		this._reducedCost = cost;
		this._title = title;
		
		_otherInformation = new HashMap<String, String>();
		_appliedCoupons = new ArrayList<AbstractCoupon>();		
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
	
	public String getInformation(String label) {
		return _otherInformation.get(label);
	}
	
	public String setInformation(String label, String details) {
		return _otherInformation.put(label, details);
	}
	
	public final float getReducedCost() {
		return _reducedCost;
	}
	
	public final void setReducedCost(float cost) {
		this._reducedCost = cost;
	}
	
	public final void resetReducedCostAndCoupons() {
		this._reducedCost = this._cost;
		this._appliedCoupons.clear();
	}
	
	public final void addAppliedCoupon(AbstractCoupon coupon) {
		this._appliedCoupons.add(coupon);
	}
	
	public final List<AbstractCoupon> getAppliedCoupons() {
		return this._appliedCoupons;
	}
}
