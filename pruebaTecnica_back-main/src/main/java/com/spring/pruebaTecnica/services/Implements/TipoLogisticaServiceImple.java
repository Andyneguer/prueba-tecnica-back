package com.spring.pruebaTecnica.services.Implements;

import com.spring.pruebaTecnica.entities.TipoLogisticaEntity;
import com.spring.pruebaTecnica.repository.TipoLogisticaInterfaceRepository;
import com.spring.pruebaTecnica.services.Interfaces.TipoLogisticaInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("serviceTipoLogistica")
public class TipoLogisticaServiceImple implements TipoLogisticaInterfaceService {

    @Autowired
    private TipoLogisticaInterfaceRepository tipoLogisticaInterfaceRepository;

    @Override
    public List<TipoLogisticaEntity> listAll() {
        return (List<TipoLogisticaEntity>) tipoLogisticaInterfaceRepository.findAll();
    }

    @Override
    public TipoLogisticaEntity save(TipoLogisticaEntity cliente) {
        return tipoLogisticaInterfaceRepository.save(cliente);
    }

    @Override
    public TipoLogisticaEntity findById(Integer id) {
        return tipoLogisticaInterfaceRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        tipoLogisticaInterfaceRepository.deleteById(id);
    }
}
