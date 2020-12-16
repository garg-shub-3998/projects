
package miniflipkart.application.service.implementationclasses;

import java.util.ArrayList;
import java.util.List;

import miniflipkart.application.entities.repository.*;
import miniflipkart.application.rdos.CartItemsRdo;
import miniflipkart.application.service.interfaces.CartService;
import miniflipkart.application.entities.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * @author Shubham Garg
 */
@Service
public class CartServiceImp implements CartService {
	
    // CartRepository Object
	@Autowired
	private CartRepository cartRepository;
	
	// ProductRepository Object
	@Autowired
	private ProductRepository productRepository;

	// OrderRepository Object
	@Autowired
	private OrderRepository orderRepository;

	// OrderRepository Object
	@Autowired
	private OrderItemsRepository orderItemsRepository;

	// UserRepository Object
	@Autowired
	private UserRepository userRepository;

	// CartItemsRepository Object
	@Autowired
	private CartItemsRepository cartItemsRepository;


	// return the number of intems in the cart
	@Override
	@Transactional
	public int getCartCount(int customerid) {
		// get cart
		Cart cart = cartRepository.findByCustomerId(customerid);
		// return the numberOfItems from the cart
		return cart.getNumberOfItems();
	}

	// add new product to cart
	@Override
	@Transactional
	public void addNewProduct(int productid, int customerid) {
		// get cart by customerid
		Cart cart = cartRepository.findByCustomerId(customerid);
		// get product
		Product product = productRepository.getOne(productid);

		// check if cart contains product
		CartItems cartItems = null;
		cartItems = cartItemsRepository.findByCartProductId(cart.getId(),product.getId());

		// cart already has product or new product is made
		if (cartItems != null) {
			// udate cart and cart item
			cart.setAmount(cart.getAmount() + product.getPrice());
			cartItems.setQuantity(cartItems.getQuantity() + 1);
			cartItems.setTotalPrice(cartItems.getTotalPrice() + product.getPrice());

			// save cart and cartitem
			cartRepository.save(cart);
			cartItemsRepository.save(cartItems);

		} else {
			// add to new CartItem
			cartItems = new CartItems(cart,product,product.getPrice(),1,product.getPrice());
			cartItemsRepository.save(cartItems);

			// update cart
			cart.setAmount(cart.getAmount() + product.getPrice());
			cart.setNumberOfItems(cart.getNumberOfItems() + 1);
			cartRepository.save(cart);
		}
	}


	// list of items in the cart
	@Override
	@Transactional
	public List<CartItemsRdo> getCartItems(int customerid) {
		// get cart
		Cart cart = cartRepository.findByCustomerId(customerid);
		// get cart items
		List<CartItems> cartitems =  cartItemsRepository.findByCartId(cart.getId());

		// generate CartItemsRdos List from cartitems
		List<CartItemsRdo> cartitemsRdos = new ArrayList<CartItemsRdo>();
		for(CartItems ci : cartitems){
			CartItemsRdo cartItemsRdo = new CartItemsRdo();
			cartItemsRdo.setId(ci.getId());
			cartItemsRdo.setProductname(ci.getProduct().getName());
			cartItemsRdo.setUnitPrice(ci.getUnitPrice());
			cartItemsRdo.setQuantity(ci.getQuantity());
			cartItemsRdo.setTotalPrice(ci.getTotalPrice());
			cartitemsRdos.add(cartItemsRdo);
		}
		return cartitemsRdos;
	}

	// delete cartitem from the cart
	@Override
	@Transactional
	public void deleteItem(int id) {
		// get cart item
		CartItems cartItems = cartItemsRepository.getOne(id);
		// get cart
		Cart cart = cartRepository.getOne(cartItems.getCart().getId());

		// update cart
		cart.setNumberOfItems(cart.getNumberOfItems() - 1);
		cart.setAmount(cart.getAmount() - cartItems.getTotalPrice());
		cartRepository.save(cart);
		// delete cart item
		cartItemsRepository.delete(cartItems);
	}

	// decrease quantity of item in the cart
	@Override
	@Transactional
	public void deleteFromItem(int id) {
		// get cart item
		CartItems cartItems = cartItemsRepository.getOne(id);
		// get cart
		Cart cart = cartRepository.getOne(cartItems.getCart().getId());

		// check if only one item is left or more is there
		if (cartItems.getQuantity() > 1) {
			// udate cart and cart item
			cart.setAmount(cart.getAmount() - cartItems.getUnitPrice());
			cartItems.setQuantity(cartItems.getQuantity() - 1);
			cartItems.setTotalPrice(cartItems.getTotalPrice() - cartItems.getUnitPrice());

			// save cart and cartitem
			cartRepository.save(cart);
			cartItemsRepository.save(cartItems);

		} else {
			// update cart
			cart.setNumberOfItems(cart.getNumberOfItems() - 1);
			cart.setAmount(cart.getAmount() - cartItems.getTotalPrice());
			cartRepository.save(cart);

			// delete cart item
			cartItemsRepository.delete(cartItems);
		}
	}

	// increase quantity of cart
	@Override
	@Transactional
	public void addToItem(int id) {
		// get cart item
		CartItems cartItems = cartItemsRepository.getOne(id);

		// get cart
		Cart cart = cartRepository.getOne(cartItems.getCart().getId());

		// udate cart and cart item
		cart.setAmount(cart.getAmount() + cartItems.getUnitPrice());
		cartItems.setQuantity(cartItems.getQuantity() + 1);
		cartItems.setTotalPrice(cartItems.getTotalPrice() + cartItems.getUnitPrice());

		// save cart and cartitem
		cartRepository.save(cart);
		cartItemsRepository.save(cartItems);
	}

	// perform checkout
	@Override
	@Transactional
	public void saveOrder(String ptype, int customerid) {
		// get cart
		Cart cart = cartRepository.findByCustomerId(customerid);
		// get customer
		User customer = userRepository.getOne(customerid);

		Order order = new Order(customer, cart.getAmount(), ptype);

		// save order
		orderRepository.save(order);

		// get list of cart items
		List<CartItems> cartItems = cartItemsRepository.findByCartId(cart.getId());


		// delete cartitems and save orderitems
		for(int i = 0; i < cartItems.size(); i++) {
			CartItems cartItem = cartItems.get(i);
			cart.setAmount(cart.getAmount() - cartItem.getTotalPrice());
			cart.setNumberOfItems(cart.getNumberOfItems() - 1);
			OrderItems orderItems = new OrderItems(order,cartItem.getProduct(),cartItem.getQuantity(),
					cartItem.getUnitPrice(),cartItem.getTotalPrice());
			cartRepository.save(cart);
			cartItemsRepository.delete(cartItem);
			orderItemsRepository.save(orderItems);
		}


	}


}
