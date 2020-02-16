package com.solucionesti.controlventas.ventasback.services;

import com.solucionesti.controlventas.ventasback.domains.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> getAll();
    public Producto getId(Long id);
    public Producto create(Producto p);
    public void delete(Long id);

}
