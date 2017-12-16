package cart.shopping.generic.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cart.shopping.generic.cart.AbstractCartItem;
import cart.shopping.generic.coupons.AbstractCoupon;

/**
 * @author Harish Prakash (harry)
 *
 */

// TODO Add comments for javadoc
// TODO implement product types. Product types should allow easy creation and multiple creation
public abstract class AbstractProduct extends AbstractCartItem {
	
	protected float cost;
	protected String title;
	protected String description;
	protected String manufacturer;
	protected HashMap<String, String> otherInformation;
	
	private float reducedCost;
	private ArrayList<AbstractCoupon> appliedCoupons;
	
	protected AbstractProduct(float cost, String title) {
		
		this.cost = cost;
		this.reducedCost = cost;
		this.title = title;
		
		this.otherInformation = new HashMap<String, String>();
		this.appliedCoupons = new ArrayList<AbstractCoupon>();		
	}
	
	public float getCost() {
		return cost;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getInformation(String label) {
		return otherInformation.get(label);
	}
	
	public String setInformation(String label, String details) {
		return otherInformation.put(label, details);
	}
	
	public final float getReducedCost() {
		return reducedCost;
	}
	
	public final void setReducedCost(float cost) {
		this.reducedCost = cost;
	}
	
	public final void resetReducedCostAndCoupons() {
		this.reducedCost = this.cost;
		this.appliedCoupons.clear();
	}
	
	public final void addAppliedCoupon(AbstractCoupon coupon) {
		this.appliedCoupons.add(coupon);
	}
	
	public final List<AbstractCoupon> getAppliedCoupons() {
		return this.appliedCoupons;
	}
}
