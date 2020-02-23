package com.solucionesti.controlventas.ventasback.services;


import com.solucionesti.controlventas.ventasback.domains.VentaDetalle;

import java.util.List;

public interface IVentaDetalleService {

    public VentaDetalle getId(Long id);
    public VentaDetalle create(VentaDetalle p);
    public void delete(Long id);

    public List<VentaDetalle> getIdVenta(Long id);
}
