package com.jeff.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DumbObjectRepository extends CrudRepository<DumbObject, Long> {

}
