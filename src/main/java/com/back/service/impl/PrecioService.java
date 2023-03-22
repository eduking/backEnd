package com.back.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.dao.IPrecioDao;
import com.back.model.Precio;
import com.back.service.IPrecioService;

@Service
public class PrecioService implements IPrecioService {

    @Autowired
    private IPrecioDao dao ;

    @Override
    public Precio registrar(Precio t) {
        return dao.save(t);
    }

    @Override
    public Precio actualizar(Precio t) {
        return dao.save(t);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public Precio listarId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarId'");
    }

    @Override
    public List<Precio> listar() {
        // TODO Auto-generated method stub
        return dao.findAll();
    }

    
}
