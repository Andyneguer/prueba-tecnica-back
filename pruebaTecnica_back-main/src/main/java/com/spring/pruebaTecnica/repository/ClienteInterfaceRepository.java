package com.spring.pruebaTecnica.repository;

import com.spring.pruebaTecnica.entities.ClienteEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClienteInterfaceRepository  extends CrudRepository<ClienteEntity, Integer> {
}
