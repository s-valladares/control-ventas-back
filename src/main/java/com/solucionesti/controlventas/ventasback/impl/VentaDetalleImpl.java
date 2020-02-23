package com.solucionesti.controlventas.ventasback.impl;

import com.solucionesti.controlventas.ventasback.domains.PedidoDetalle;
import com.solucionesti.controlventas.ventasback.domains.VentaDetalle;
import com.solucionesti.controlventas.ventasback.repositories.IPedidoDetalleDao;
import com.solucionesti.controlventas.ventasback.repositories.IVentaDetalleDao;
import com.solucionesti.controlventas.ventasback.services.IPedidoDetalleService;
import com.solucionesti.controlventas.ventasback.services.IVentaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentaDetalleImpl implements IVentaDetalleService {

    @Autowired
    private IVentaDetalleDao objDao;

    @Override
    @Transactional(readOnly = true)
    public List<VentaDetalle> getIdVenta(Long id) {
        return (List<VentaDetalle>) objDao.findAll();
    }

    @Override
    public VentaDetalle getId(Long id) {
        return objDao.findById(id).orElse(null);
    }

    @Override
    public VentaDetalle create(VentaDetalle obj) {
        return objDao.save(obj);
    }

    @Override
    public void delete(Long id) {
        objDao.deleteById(id);
    }



}
