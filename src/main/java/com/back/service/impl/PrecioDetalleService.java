package com.back.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.dao.IPrecioDetalleDao;
import com.back.model.PrecioDetalle;
import com.back.service.IPrecioDetalleService;

@Service
public class PrecioDetalleService implements IPrecioDetalleService {

    @Autowired
    private IPrecioDetalleDao dao ;

    @Override
    public PrecioDetalle registrar(PrecioDetalle t) {
        return dao.save(t);
    }

    @Override
    public PrecioDetalle actualizar(PrecioDetalle t) {
        return dao.save(t);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public PrecioDetalle listarId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarId'");
    }

    @Override
    public List<PrecioDetalle> listar() {
        // TODO Auto-generated method stub
        return dao.findAll();
    }

    
}
