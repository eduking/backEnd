package com.back.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.back.model.PrecioDetalle;
import com.back.service.IPrecioDetalleService;
import com.back.resp.BaseResp;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/precioDetalle")
public class PrecioDetallecontroller {
    
    @Autowired
    IPrecioDetalleService iPrecioDetalleService;

    @GetMapping(value ="/findAll",produces="application/json")
    public ResponseEntity<List<PrecioDetalle>>findAll(){
        List<PrecioDetalle>preciosDetalle=new ArrayList<>();
        preciosDetalle=iPrecioDetalleService.listar();
        return new ResponseEntity<List<PrecioDetalle>>(preciosDetalle,HttpStatus.OK);

    }
    
    @PostMapping(value = "/crearPrecioDetall", produces = "application/json", consumes = "application/json")
    public BaseResp register(@RequestBody PrecioDetalle precDetall) {
        BaseResp baseResp = new BaseResp();
        baseResp.setStatusCode(201);
        baseResp.setMessage("CREADO");
        baseResp.setData(precDetall);
        iPrecioDetalleService.registrar(precDetall);
        return baseResp;
    }

    @PutMapping(value = "/updatePreDetall", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> modificar(@RequestBody PrecioDetalle precDetall) {
        iPrecioDetalleService.actualizar(precDetall);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        iPrecioDetalleService.eliminar(id);
    }
    
}
