package net.viralpatel.springbootgraphqljava.customers.data;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerModel, Long> {

}
