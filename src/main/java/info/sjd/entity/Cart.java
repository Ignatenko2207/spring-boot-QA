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
@Table(name = "carts")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "time")
	private Long time;
	
	@ManyToOne(targetEntity = User.class)
	private User user;
	
	@Column(name = "status")
	private Status status;

	public Cart(Long time, User user, Status status) {
		this.time = time;
		this.user = user;
		this.status = status;
	}
}
