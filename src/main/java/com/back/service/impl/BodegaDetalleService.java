package com.back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.dao.IBodegaDetalleDao;
import com.back.model.BodegaDetalle;
import com.back.service.IBodegaDetalleService;

@Service
public class BodegaDetalleService implements IBodegaDetalleService {

    @Autowired
    private IBodegaDetalleDao dao;

    @Override
    public BodegaDetalle registrar(BodegaDetalle t) {
        return dao.save(t);
    }

    @Override
    public BodegaDetalle actualizar(BodegaDetalle t) {
        return dao.save(t);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public BodegaDetalle listarId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarId'");
    }

    @Override
    public List<BodegaDetalle> listar() {
        // TODO Auto-generated method stub
        return dao.findAll();
    }

    
}
