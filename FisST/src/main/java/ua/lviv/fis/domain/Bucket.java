package ua.lviv.fis.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BucketOfBuys")
public class Bucket {

	@Id
	@Column(name = "BucketId")
	private int id;

	@Column(name = "usersBucket")
	
	private User user;

	@Column(name = "productsInBucket")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ProductsInBucket", joinColumns = { @JoinColumn(name = "BucketId") }, inverseJoinColumns = { @JoinColumn(name = "User_id") })
	private List<Product> products;
	
	public Bucket() {
	}
	
	
	public Bucket(User user, List<Product> products) {
	
		this.user = user;
		this.products = products;
	}
	

	public Bucket(int id, User user, List<Product> products) {
		this.id = id;
		this.user = user;
		this.products = products;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}


	@Override
	public String toString() {
		return "Bucket [id=" + id + ", user=" + user + ", products=" + products
				+ "]";
	}
	
}
