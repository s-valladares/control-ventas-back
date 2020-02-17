package com.solucionesti.controlventas.ventasback.impl;

import com.solucionesti.controlventas.ventasback.domains.Pedido;
import com.solucionesti.controlventas.ventasback.domains.PedidoDetalle;
import com.solucionesti.controlventas.ventasback.repositories.IPedidoDao;
import com.solucionesti.controlventas.ventasback.repositories.IPedidoDetalleDao;
import com.solucionesti.controlventas.ventasback.services.IPedidoDetalleService;
import com.solucionesti.controlventas.ventasback.services.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoDetalleImpl implements IPedidoDetalleService {

    @Autowired
    private IPedidoDetalleDao objDao;

    @Override
    @Transactional(readOnly = true)
    public List<PedidoDetalle> getIdPedido(Long id) {
        return (List<PedidoDetalle>) objDao.findAll();
    }

    @Override
    public PedidoDetalle getId(Long id) {
        return objDao.findById(id).orElse(null);
    }

    @Override
    public PedidoDetalle create(PedidoDetalle obj) {
        return objDao.save(obj);
    }

    @Override
    public void delete(Long id) {
        objDao.deleteById(id);
    }



}
