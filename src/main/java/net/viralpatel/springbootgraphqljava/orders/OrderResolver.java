package net.viralpatel.springbootgraphqljava.orders;

import graphql.kickstart.tools.GraphQLResolver;
import net.viralpatel.springbootgraphqljava.customers.Customer;
import net.viralpatel.springbootgraphqljava.customers.data.CustomerModel;
import net.viralpatel.springbootgraphqljava.customers.data.CustomerRepository;
import net.viralpatel.springbootgraphqljava.products.Product;
import net.viralpatel.springbootgraphqljava.products.data.ProductModel;
import net.viralpatel.springbootgraphqljava.products.data.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderResolver implements GraphQLResolver<Order> {

    private ProductRepository productRepository;
    private CustomerRepository customerRepository;

    public OrderResolver(ProductRepository productRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    public Customer customer(Order order) {
        return customerRepository.findById(order.getCustomer().getId())
                .map(this::modelToGraphQL)
                .orElse(null);
    }

    public Product product(Order order) {
        return productRepository.findById(order.getProduct().getId())
                .map(this::modelToGraphQL)
                .orElse(null);
    }

    private Product modelToGraphQL(ProductModel productModel) {
        Product product = new Product();
        product.setDescription(productModel.getDescription());
        product.setName(productModel.getName());
        product.setId(productModel.getId());
        product.setPrice(productModel.getPrice());
        return product;
    }

    private Customer modelToGraphQL(CustomerModel customerModel) {
        Customer customer = new Customer();
        customer.setEmail(customerModel.getEmail());
        customer.setId(customerModel.getId());
        customer.setName(customerModel.getName());
        return customer;
    }

}
