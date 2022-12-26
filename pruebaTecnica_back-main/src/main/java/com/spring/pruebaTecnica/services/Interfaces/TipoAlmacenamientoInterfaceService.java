package com.spring.pruebaTecnica.services.Interfaces;

import com.spring.pruebaTecnica.entities.TipoAlmacenamientoEntity;

import java.util.List;

public interface TipoAlmacenamientoInterfaceService {

    public List<TipoAlmacenamientoEntity> listAll();

    public TipoAlmacenamientoEntity save(TipoAlmacenamientoEntity almacen);

    public void delete(Integer id);

    TipoAlmacenamientoEntity findById(Integer id);
}
