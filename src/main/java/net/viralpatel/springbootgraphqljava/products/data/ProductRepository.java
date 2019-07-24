package net.viralpatel.springbootgraphqljava.products.data;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductModel, Long> {
}
