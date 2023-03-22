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
import com.back.model.Bodega;
import com.back.resp.BaseResp;
import com.back.service.IBodegaService;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("/api/bodega")
public class Bodegacontroller {
    
    @Autowired
    IBodegaService iBodegaService;

    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<List<Bodega>> findAll() {
        List<Bodega> bodegas = new ArrayList<>();
        bodegas = iBodegaService.listar();
        return new ResponseEntity<List<Bodega>>(bodegas, HttpStatus.OK);

    }

    @GetMapping(value = "/listarVista", produces = "application/json")
    public ResponseEntity<List<Object>> ListarVista() {
        List<Object> lista = new ArrayList<>();
        lista = iBodegaService.listarvista();
        return new ResponseEntity<List<Object>>(lista, HttpStatus.OK);

    }

    @PostMapping(value = "/crearBodega", produces = "application/json", consumes = "application/json")
    public BaseResp register(@RequestBody Bodega bodega) {
        BaseResp baseResp = new BaseResp();
        baseResp.setStatusCode(201);
        baseResp.setMessage("CREADO");
        baseResp.setData(bodega);
        iBodegaService.registrar(bodega);
        return baseResp;
    }

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> modificar(@RequestBody Bodega bodega) {
        iBodegaService.actualizar(bodega);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        iBodegaService.eliminar(id);
    }

}
