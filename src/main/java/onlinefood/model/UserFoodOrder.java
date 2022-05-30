package onlinefood.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "userorderfood")
public class UserFoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int usertablerow;
	
	private int foodId;

	@NotEmpty
	@Size(min = 2, max = 20, message = "foodname  should be in given size")
	private String foodName;

	@Size(min = 2, max = 30, message = "foodname  should be in given size")
	private String foodType;

	@Positive
	private double foodPrice;

	@JoinColumn(name = "foodQuantity")
	private double foodQuentity;

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public double getFoodQuentity() {
		return foodQuentity;
	}

	public void setFoodQuentity(double foodQuentity) {
		this.foodQuentity = foodQuentity;
	}

	public UserFoodOrder() {
		super();
	}

	@ManyToOne(fetch = FetchType.LAZY)
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public UserFoodOrder(int foodId, String foodName, String foodType, double foodPrice, double foodQuentity,
			Order order) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodType = foodType;
		this.foodPrice = foodPrice;
		this.foodQuentity = foodQuentity;
		this.order = order;
	}

	@Override
	public String toString() {
		return "UserFoodOrder [foodId=" + foodId + ", foodName=" + foodName + ", foodType=" + foodType + ", foodPrice="
				+ foodPrice + ", foodQuentity=" + foodQuentity + ", order=" + order + "]";
	}

}
