package com.spring.pruebaTecnica.services.Implements;


import com.spring.pruebaTecnica.entities.TipoProductoEntity;
import com.spring.pruebaTecnica.repository.TipoProductoInterfaceRepository;
import com.spring.pruebaTecnica.services.Interfaces.TipoProductoInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("serviceTipoProducto")
public class TipoProductoServiceImple implements TipoProductoInterfaceService {

    @Autowired
    private TipoProductoInterfaceRepository tipoProductoInterfaceRepository;

    @Override
    public List<TipoProductoEntity> listAll() {
        return (List<TipoProductoEntity>) tipoProductoInterfaceRepository.findAll();
    }

    @Override
    public TipoProductoEntity save(TipoProductoEntity cliente) {
        return tipoProductoInterfaceRepository.save(cliente);
    }

    @Override
    public TipoProductoEntity findById(Integer id) {
        return tipoProductoInterfaceRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        tipoProductoInterfaceRepository.deleteById(id);
    }
}