package com.solucionesti.controlventas.ventasback.impl;


import com.solucionesti.controlventas.ventasback.domains.PedidoDetalle;
import com.solucionesti.controlventas.ventasback.domains.Venta;
import com.solucionesti.controlventas.ventasback.domains.VentaDetalle;
import com.solucionesti.controlventas.ventasback.repositories.IVentaDao;
import com.solucionesti.controlventas.ventasback.services.IPedidoDetalleService;
import com.solucionesti.controlventas.ventasback.services.IPedidoService;
import com.solucionesti.controlventas.ventasback.services.IVentaDetalleService;
import com.solucionesti.controlventas.ventasback.services.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentaImpl implements IVentaService {

    @Autowired
    private IVentaDao objDao;

    @Autowired
    private IPedidoDetalleService detalleService;

    @Autowired
    private IVentaDetalleService ventaDetalleService;
    @Autowired
    private IPedidoService pedidoService;


    @Override
    @Transactional(readOnly = true)
    public List<Venta> getAll() {
        return (List<Venta>) objDao.findAll();
    }

    @Override
    public Venta getId(Long id) {
        return objDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Venta create(Venta obj) {
        List<PedidoDetalle> pedidoDetalles;
        Venta venta = objDao.save(obj);

        pedidoDetalles = detalleService.getIdPedido(obj.getPedido().getId());

        for (PedidoDetalle detalle : pedidoDetalles) {
            VentaDetalle ventaDetalle = new VentaDetalle();
            ventaDetalle.setPedidoDetalle(detalle);
            ventaDetalle.setVenta(venta);
            ventaDetalleService.create(ventaDetalle);
        }

        venta.getPedido().setEstado(false);
        pedidoService.create(venta.getPedido());

        return venta;
    }

    @Override
    public void delete(Long id) {
        objDao.deleteById(id);
    }

}
