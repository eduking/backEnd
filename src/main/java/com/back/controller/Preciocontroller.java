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
import com.back.model.Precio;
import com.back.service.IPrecioService;
import com.back.resp.BaseResp;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/precio")
public class Preciocontroller {
    
    @Autowired
    IPrecioService iPrecioService;

    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<List<Precio>> findAll() {
        List<Precio> precios= new ArrayList<>();
        precios = iPrecioService.listar();
        return new ResponseEntity<List<Precio>>(precios, HttpStatus.OK);

    }

    @PostMapping(value = "/crearPrecio", produces = "application/json", consumes = "application/json")
    public BaseResp register(@RequestBody Precio prec) {
        BaseResp baseResp = new BaseResp();
        baseResp.setStatusCode(201);
        baseResp.setMessage("CREADO");
        baseResp.setData(prec);
        iPrecioService.registrar(prec);
        return baseResp;
    }

    @PutMapping(value = "/updatePrecio", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> modificar(@RequestBody Precio prec) {
        iPrecioService.actualizar(prec);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        iPrecioService.eliminar(id);
    }
    

}
