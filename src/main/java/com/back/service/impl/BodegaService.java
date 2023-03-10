package com.back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.dao.IBodegaDao;
import com.back.model.Bodega;
import com.back.service.IBodegaService;

@Service
public class BodegaService implements IBodegaService {

    @Autowired
    private IBodegaDao dao ;

    @Override
    public Bodega registrar(Bodega t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrar'");
    }

    @Override
    public Bodega actualizar(Bodega t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public void eliminar(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public Bodega listarId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarId'");
    }

    @Override
    public List<Bodega> listar() {
        // TODO Auto-generated method stub
        return dao.findAll();
    }



    
}
