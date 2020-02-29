package com.solucionesti.controlventas.ventasback.services;


import com.solucionesti.controlventas.ventasback.domains.Venta;

import java.util.List;

public interface IVentaService {
    List<Venta> getAll();
    Venta getId(Long id);
    Venta create(Venta p);
    void delete(Long id);

    // Mostrar ventas que pertenecen a cierta semana de venta
    List<Venta> verVentasPorSemanaVenta(Long idSemanaVenta);

}
