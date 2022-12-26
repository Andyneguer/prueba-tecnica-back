package com.spring.pruebaTecnica.services.Interfaces;

import com.spring.pruebaTecnica.entities.AlmacenamientoEntity;

import java.util.List;

public interface AlmacenamientoInterfaceService {

    public List<AlmacenamientoEntity> listAll();

    public AlmacenamientoEntity save(AlmacenamientoEntity almacen);

    public Integer insertar(AlmacenamientoEntity almacen);

    public Integer update(AlmacenamientoEntity almacen);

    public void delete(Integer id);

    AlmacenamientoEntity findById(Integer id);

    AlmacenamientoEntity findById2(Integer id);

    public List<AlmacenamientoEntity> obtenerConTipoAlmacenamiento();

}
