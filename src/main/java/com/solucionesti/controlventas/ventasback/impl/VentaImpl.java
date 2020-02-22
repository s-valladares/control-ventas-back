package com.solucionesti.controlventas.ventasback.impl;

import com.solucionesti.controlventas.ventasback.domains.Pedido;
import com.solucionesti.controlventas.ventasback.domains.Venta;
import com.solucionesti.controlventas.ventasback.repositories.IPedidoDao;
import com.solucionesti.controlventas.ventasback.repositories.IVentaDao;
import com.solucionesti.controlventas.ventasback.services.IPedidoService;
import com.solucionesti.controlventas.ventasback.services.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentaImpl implements IVentaService {

    @Autowired
    private IVentaDao objDao;

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
    public Venta create(Venta obj) {
        return objDao.save(obj);
    }

    @Override
    public void delete(Long id) {
        objDao.deleteById(id);
    }


}
