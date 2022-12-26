package com.spring.pruebaTecnica;

import com.spring.pruebaTecnica.repository.UsuarioInterfaceRepository;
import com.spring.pruebaTecnica.services.Implements.UsuarioServiceImple;
import com.spring.pruebaTecnica.services.Interfaces.UsuarioInterfaceService;
import com.spring.pruebaTecnica.entities.UsuarioEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;

@RunWith(SpringRunner.class)
public class UsuarioServiceTest {

    private UsuarioInterfaceService iServiceUsuario;
    private UsuarioInterfaceRepository iUsuarioRepository;

    @Test
    public void testCargarListaVacia(){
        iUsuarioRepository = Mockito.mock(UsuarioInterfaceRepository.class);
        iServiceUsuario = new UsuarioServiceImple(iUsuarioRepository);
        Mockito.when(iUsuarioRepository.findAll()).thenReturn(Collections.emptyList());
        Assert.assertTrue(iServiceUsuario.listAll().isEmpty());
    }

    @Test
    public void testCargarLista(){
        iUsuarioRepository = Mockito.mock(UsuarioInterfaceRepository.class);
        iServiceUsuario = new UsuarioServiceImple(iUsuarioRepository);
        Mockito.when(iUsuarioRepository.findAll()).thenReturn(Arrays.asList(new UsuarioEntity()));
        Assert.assertEquals(1,iServiceUsuario.listAll().size());
    }


}
