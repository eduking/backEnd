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
import com.back.model.Detalle;
import com.back.service.IDetalleService;
import com.back.resp.BaseResp;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/detalle")
public class Detallecontroller {
    
    @Autowired
    IDetalleService iDetalleService;

    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<List<Detalle>> findAll() {
        List<Detalle> detalles= new ArrayList<>();
        detalles = iDetalleService.listar();
        return new ResponseEntity<List<Detalle>>(detalles, HttpStatus.OK);

    }

    @PostMapping(value = "/crearDetalle", produces = "application/json", consumes = "application/json")
    public BaseResp register(@RequestBody Detalle detall) {
        BaseResp baseResp = new BaseResp();
        baseResp.setStatusCode(201);
        baseResp.setMessage("CREADO");
        baseResp.setData(detall);
        iDetalleService.registrar(detall);
        return baseResp;
    }

    @PutMapping(value = "/updateDetalle", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> modificar(@RequestBody Detalle detall) {
        iDetalleService.actualizar(detall);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        iDetalleService.eliminar(id);
    }

}
