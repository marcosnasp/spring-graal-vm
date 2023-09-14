package com.example.spring.graal.vm.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class OrderCostumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_costumer_id")
    private Long orderCostumerId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "orderCostumer")
    private List<OrderItem> orderItems;

    public OrderCostumer() {

    }

    public Long getOrderCostumerId() {
        return orderCostumerId;
    }

    public void setOrderCostumerId(Long orderCostumerId) {
        this.orderCostumerId = orderCostumerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderCostumer orderCostumer = (OrderCostumer) o;
        return Objects.equals(orderCostumerId, orderCostumer.orderCostumerId) && Objects.equals(customer, orderCostumer.customer) && Objects.equals(orderDate, orderCostumer.orderDate) && Objects.equals(totalAmount, orderCostumer.totalAmount) && Objects.equals(orderItems, orderCostumer.orderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderCostumerId, customer, orderDate, totalAmount, orderItems);
    }
}
