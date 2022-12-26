package com.spring.pruebaTecnica.services.Interfaces;

import com.spring.pruebaTecnica.entities.TipoLogisticaEntity;

import java.util.List;

public interface TipoLogisticaInterfaceService {
    public List<TipoLogisticaEntity> listAll();

    public TipoLogisticaEntity save(TipoLogisticaEntity almacen);

    public void delete(Integer id);

    TipoLogisticaEntity findById(Integer id);
}
