package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServicelmpl implements CustomerService {
    private static Map<Integer, Customer> customer;

    static {
        customer = new HashMap<>();
        customer.put(1, new Customer(1, "trung1", "trungtran", "dn"));
        customer.put(2, new Customer(2, "trung2", "trungtran", "dn"));
        customer.put(3, new Customer(3, "trung3", "trungtran", "dn"));
        customer.put(4, new Customer(4, "trung4", "trungtran", "dn"));
        customer.put(5, new Customer(5, "trung5", "trungtran", "dn"));
        customer.put(6, new Customer(6, "trung6", "trungtran", "dn"));
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        return customers = new ArrayList<>(customer.values());
    }

    @Override
    public void save(Customer customer1) {
        customer.put(customer1.getId(), customer1);

    }

    @Override
    public Customer findById(int id) {
        return customer.get(id);
    }

    @Override
    public void update(int id, Customer customer1) {
        customer.put(id, customer1);
    }

    @Override
    public void remove(int id) {
        customer.remove(id);
    }
}
