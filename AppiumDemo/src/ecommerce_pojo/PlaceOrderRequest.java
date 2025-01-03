package ecommerce_pojo;

import java.util.List;

public class PlaceOrderRequest {
	private List<PlaceOrder_OrderDetailsRequest> orders;

	public List<PlaceOrder_OrderDetailsRequest> getOrders() {
		return orders;
	}
	
	public void setOrders(List<PlaceOrder_OrderDetailsRequest> orders) {
		this.orders = orders;
	}
}
