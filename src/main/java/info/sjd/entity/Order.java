package info.sjd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(targetEntity = Item.class)
	private Item item;
	
	@Column(name = "amount")
	private Integer amount;
	
	@ManyToOne(targetEntity = Cart.class)
	private Cart cart;

	public Order(Item item, Integer amount, Cart cart) {
		this.item = item;
		this.amount = amount;
		this.cart = cart;
	}
}
