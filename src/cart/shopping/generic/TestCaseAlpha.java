package cart.shopping.generic;

import cart.shopping.generic.cart.Cart;

public class TestCaseAlpha {
	
	public static void main(String[] args) {
		
		Cart shoppingCart = Cart.initialize();

		shoppingCart.addCartItem(EntrustTestProjectDictionary.tshirtOldNavy);
		shoppingCart.addCartItem(EntrustTestProjectDictionary.tshirtOldNavy);
		shoppingCart.addCartItem(EntrustTestProjectDictionary.tshirtOldNavy);
		System.out.println(String.format("Cart Total: %.2f | Added 3x T-Shirts", shoppingCart.getCartTotal()));

		shoppingCart.addCartItem(EntrustTestProjectDictionary.percentTwentyOffNextItem);
		System.out.println(String.format("Cart Total: %.2f | Applied Coupon 20%% off next item", shoppingCart.getCartTotal()));

		shoppingCart.addCartItem(EntrustTestProjectDictionary.jacketRaynolds);
		shoppingCart.addCartItem(EntrustTestProjectDictionary.jacketRaynolds);
		System.out.println(String.format("Cart Total: %.2f | Added 2x Jackets", shoppingCart.getCartTotal()));

		for (int count = 10; count > 0; count --) shoppingCart.addCartItem(EntrustTestProjectDictionary.braceletTitan);
		System.out.println(String.format("Cart Total: %.2f | Added 10x Bracelets", shoppingCart.getCartTotal()));

		shoppingCart.addCartItem(EntrustTestProjectDictionary.percentTenOffPreviousItems);
		System.out.println(String.format("Cart Total: %.2f | Applied Coupon 10%% off previous items", shoppingCart.getCartTotal()));

		shoppingCart.addCartItem(EntrustTestProjectDictionary.dollarsSeventyFiveOffOnFifthJacket);
		shoppingCart.addCartItem(EntrustTestProjectDictionary.dollarsSeventyFiveOffOnFifthJacket);
		System.out.println(String.format("Cart Total: %.2f | Applied Coupon 2x $75 off 5th Jacket", shoppingCart.getCartTotal()));

		shoppingCart.addCartItem(EntrustTestProjectDictionary.jacketRaynolds);
		shoppingCart.addCartItem(EntrustTestProjectDictionary.jacketRaynolds);
		System.out.println(String.format("Cart Total: %.2f | Added 2x Jackets", shoppingCart.getCartTotal()));

		shoppingCart.addCartItem(EntrustTestProjectDictionary.jacketRaynolds);
		System.out.println(String.format("Cart Total: %.2f | Added 1x Jackets", shoppingCart.getCartTotal()));
	}

}
