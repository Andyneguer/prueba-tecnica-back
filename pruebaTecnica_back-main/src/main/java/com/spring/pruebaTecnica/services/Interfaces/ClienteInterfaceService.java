package com.spring.pruebaTecnica.services.Interfaces;


import com.spring.pruebaTecnica.entities.ClienteEntity;

import java.util.List;

public interface ClienteInterfaceService {
    public List<ClienteEntity> listAll();

    public List<ClienteEntity> listSelect();

    public ClienteEntity save(ClienteEntity cliente);

    public ClienteEntity findById(Integer id);

    public void delete(Integer id);
}
