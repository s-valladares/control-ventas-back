package com.solucionesti.controlventas.ventasback.services;

import com.solucionesti.controlventas.ventasback.domains.Venta;

import java.util.List;

public interface IVentaService {
    public List<Venta> getAll();
    public Venta getId(Long id);
    public Venta create(Venta p);
    public void delete(Long id);

}
