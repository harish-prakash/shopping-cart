package cart.shopping.generic.exceptions;

public class ShoppingCartException extends UnsupportedOperationException {

	private static final long serialVersionUID = -3762510689649327666L;

	public ShoppingCartException() {

		super("Unknown exception occured. Please contact the administrator at 987-654-3210");
	}

	public ShoppingCartException(String message) {
		super(message);
	}

	public ShoppingCartException(Throwable cause) {
		super(cause);
	}

	public ShoppingCartException(String message, Throwable cause) {
		super(message, cause);
	}

}
