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
import com.back.model.BodegaDetalle;
import com.back.service.IBodegaDetalleService;
import com.back.resp.BaseResp;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/bodegaDetalle")
public class BodegaDetallecontroller {
    
    @Autowired
    IBodegaDetalleService iBodegaDetalleService;


    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<List<BodegaDetalle>> findAll() {
        List<BodegaDetalle> bodegasdetalles= new ArrayList<>();
        bodegasdetalles = iBodegaDetalleService.listar();
        return new ResponseEntity<List<BodegaDetalle>>(bodegasdetalles, HttpStatus.OK);

    }

    @PostMapping(value = "/crearBodegaDetall", produces = "application/json", consumes = "application/json")
    public BaseResp register(@RequestBody BodegaDetalle bodegadetall) {
        BaseResp baseResp = new BaseResp();
        baseResp.setStatusCode(201);
        baseResp.setMessage("CREADO");
        baseResp.setData(bodegadetall);
        iBodegaDetalleService.registrar(bodegadetall);
        return baseResp;
    }

    @PutMapping(value = "/updateBodegaDetall", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> modificar(@RequestBody BodegaDetalle bodegadetall) {
        iBodegaDetalleService.actualizar(bodegadetall);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        iBodegaDetalleService.eliminar(id);
    }
}
