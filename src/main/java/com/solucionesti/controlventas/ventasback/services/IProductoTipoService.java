package com.solucionesti.controlventas.ventasback.services;

import com.solucionesti.controlventas.ventasback.domains.ProductoTipo;

import java.util.List;

public interface IProductoTipoService {
    public List<ProductoTipo> getAll();
    public ProductoTipo getId(Long id);
}
