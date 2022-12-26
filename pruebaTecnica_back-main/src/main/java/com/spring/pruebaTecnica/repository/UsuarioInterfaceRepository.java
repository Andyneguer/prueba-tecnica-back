package com.spring.pruebaTecnica.repository;

import com.spring.pruebaTecnica.entities.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioInterfaceRepository extends CrudRepository<UsuarioEntity, Integer> {
    public UsuarioEntity findByUsername(String username);
}
