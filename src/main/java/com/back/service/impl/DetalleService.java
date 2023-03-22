package com.back.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.dao.IDetalleDao;
import com.back.model.Detalle;
import com.back.service.IDetalleService;

@Service
public class DetalleService implements IDetalleService {

    @Autowired
    private IDetalleDao dao ;

    @Override
    public Detalle registrar(Detalle t) {
        return dao.save(t);
    }

    @Override
    public Detalle actualizar(Detalle t) {
        return dao.save(t);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public Detalle listarId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarId'");
    }

    @Override
    public List<Detalle> listar() {
        // TODO Auto-generated method stub
        return dao.findAll();
    }

    
}
