package fr.test.testJpa.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "T_ASSO_CUSTOMER_ORDER",
            joinColumns =
            @JoinColumn(name="customer_id", referencedColumnName="ID", foreignKey = @ForeignKey(name = "ASSO_CUST_ORD_CUSTOMER_ID_FK")),
            inverseJoinColumns=
            @JoinColumn(name="order_id", referencedColumnName="ID", foreignKey = @ForeignKey(name = "ASSO_CUST_ORD_ORDER_ID_FK")))
    private List<Order> orders = new ArrayList<>();
    
    public Customer(){}
    
    public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
