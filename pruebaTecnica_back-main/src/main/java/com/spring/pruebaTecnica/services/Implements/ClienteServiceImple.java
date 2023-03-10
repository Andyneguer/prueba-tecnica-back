package com.spring.pruebaTecnica.services.Implements;

import com.spring.pruebaTecnica.entities.ClienteEntity;
import com.spring.pruebaTecnica.repository.ClienteInterfaceRepository;
import com.spring.pruebaTecnica.services.Interfaces.ClienteInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("serviceCliente")
public class ClienteServiceImple implements ClienteInterfaceService {

    @Autowired
    private ClienteInterfaceRepository clienteInterfaceRepository;

    @Override
    public List<ClienteEntity> listAll() {
        return (List<ClienteEntity>) clienteInterfaceRepository.findAll();
    }

    @Override
    public List<ClienteEntity> listSelect() {
        return (List<ClienteEntity>) clienteInterfaceRepository.findAll();
    }

    @Override
    public ClienteEntity save(ClienteEntity cliente) {
        return clienteInterfaceRepository.save(cliente);
    }

    @Override
    public ClienteEntity findById(Integer id) {
        return clienteInterfaceRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        clienteInterfaceRepository.deleteById(id);
    }
}
