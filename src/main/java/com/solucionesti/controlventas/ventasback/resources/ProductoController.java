package com.solucionesti.controlventas.ventasback.resources;

import com.solucionesti.controlventas.ventasback.config.UrlBaseApi;
import com.solucionesti.controlventas.ventasback.domains.Producto;
import com.solucionesti.controlventas.ventasback.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(UrlBaseApi.URL_API)

public class ProductoController {

    private final String entidad = "/productos";

    @Autowired
    private IProductoService objService;

    @GetMapping(entidad)
    public List<Producto> index() { return objService.getAll(); }

}
