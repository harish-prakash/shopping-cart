package cart.shopping.generic;

import cart.shopping.generic.cart.Cart;
import cart.shopping.generic.coupons.CouponDollarsOffNthProductType;
import cart.shopping.generic.coupons.CouponPercentOffAllItemsUntilNow;
import cart.shopping.generic.coupons.CouponPercentOffNextItem;
import cart.shopping.generic.products.ProductBracelet;
import cart.shopping.generic.products.ProductJacket;
import cart.shopping.generic.products.ProductTShirt;

public class UserInterface {
	
	public static void main(String[] args) {
		
		Cart shoppingCart = Cart.initialize();
		
		shoppingCart.addCartItems(ProductTShirt.initialize(3));
		System.out.println(String.format("Cart total $%.2f | Added 3x T-shirts", shoppingCart.getCartTotal()));
		
		shoppingCart.addCartItems(CouponPercentOffNextItem.initialize(20));
		System.out.println(String.format("Cart total $%.2f | Applied 20%% off next item", shoppingCart.getCartTotal()));
		
		shoppingCart.addCartItems(ProductJacket.initialize(2));
		System.out.println(String.format("Cart total $%.2f | Added 2x jackets", shoppingCart.getCartTotal()));
		
		shoppingCart.addCartItems(ProductBracelet.initialize(10));
		System.out.println(String.format("Cart total $%.2f | Added 10x Bracelets", shoppingCart.getCartTotal()));
		
		shoppingCart.addCartItems(CouponPercentOffAllItemsUntilNow.initialize(10));
		System.out.println(String.format("Cart total $%.2f | Applied 10%% off cart", shoppingCart.getCartTotal()));
		
		shoppingCart.addCartItems(CouponDollarsOffNthProductType.initialize(ProductJacket.class, 75, 5, 2));
		System.out.println(String.format("Cart total $%.2f | Applied 2x $75 off on 5th Jacket coupons", shoppingCart.getCartTotal()));
		
		shoppingCart.addCartItems(ProductJacket.initialize(2));
		System.out.println(String.format("Cart total $%.2f | Added 2x Jackets", shoppingCart.getCartTotal()));
		
		shoppingCart.addCartItems(ProductJacket.initialize());
		System.out.println(String.format("Cart total $%.2f | Added 1x Jackets", shoppingCart.getCartTotal()));
	}

}
