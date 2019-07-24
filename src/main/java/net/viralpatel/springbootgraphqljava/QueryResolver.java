package net.viralpatel.springbootgraphqljava;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import net.viralpatel.springbootgraphqljava.customers.Customer;
import net.viralpatel.springbootgraphqljava.customers.data.CustomerModel;
import net.viralpatel.springbootgraphqljava.customers.data.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private CustomerRepository customerRepository;

    public QueryResolver(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer customerById(Long id) {
        return customerRepository
                .findById(id)
                .map(this::modelToGraphQL)
                .orElse(null);
    }

    private Customer modelToGraphQL(CustomerModel customerModel) {
        Customer customer = new Customer();
        customer.setId(customerModel.getId());
        customer.setName(customerModel.getName());
        customer.setEmail(customerModel.getEmail());

        return customer;
    }
}
