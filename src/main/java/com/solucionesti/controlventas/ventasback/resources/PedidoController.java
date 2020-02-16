package com.solucionesti.controlventas.ventasback.resources;

import com.solucionesti.controlventas.ventasback.config.UrlBaseApi;
import com.solucionesti.controlventas.ventasback.domains.Pedido;
import com.solucionesti.controlventas.ventasback.services.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(UrlBaseApi.URL_API)

public class PedidoController {

    private final String entidad = "/pedidos";

    @Autowired
    private IPedidoService objService;

    @GetMapping(entidad)
    public ResponseEntity<?> index() {
        List<Pedido> objNew = null;
        Map<String, Object> response = new HashMap<>();
        try {
            objNew = objService.getAll();
        } catch (DataAccessException ex) {
            response.put("mensaje", "Error al obtener de la base de datos");
            response.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("size", objNew.size());
        response.put("rows", objNew);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping(entidad + "/{id}" )
    public ResponseEntity<?> show(@PathVariable Long id) {

        Pedido obj = null;
        Map<String, Object> response = new HashMap<>();

        try {
            obj = objService.getId(id);
        } catch (DataAccessException ex) {
            response.put("mensaje", "Error al consultar base de datos");
            response.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (obj == null) {
            response.put("mensaje", entidad.toUpperCase() + " ID: ".concat(id.toString().concat(" No existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Pedido>(obj, HttpStatus.OK);
    }

    @PostMapping(entidad)
    public ResponseEntity<?> create(@Valid @RequestBody Pedido x, BindingResult result) {

        Pedido objNew = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream().map(err -> {
                return "El campo '" + err.getField() + "' " + err.getDefaultMessage();
            }).collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            //System.out.print(x.getApellidos());
            objNew = objService.create(x);

        } catch (DataAccessException ex) {
            response.put("mensaje", "Error al insertar en la base de datos");
            response.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "OK");
        response.put("RES", objNew);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping(entidad + "/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Pedido fl, BindingResult result, @PathVariable Long id) {

        Pedido flActual = objService.getId(id);
        Pedido flActualizado = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream().map(err -> {
                return "El campo '" + err.getField() + "'" + err.getDefaultMessage();
            }).collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if (flActual == null) {
            response.put("mensaje", "Error: no hay objeto con con id: "
                    .concat(id.toString().concat(". No existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {

            flActual.setCliente(fl.getCliente());
            flActual.setEntrega(fl.getEntrega());
            flActual.setEstado(fl.getEstado());

            flActualizado = objService.create(flActual);
        } catch (DataAccessException ex) {
            response.put("mensaje", "Error actualizar el objeto en la base de datos");
            response.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El objeto fue actualizado correctamente");
        response.put("RES", flActualizado);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

}
