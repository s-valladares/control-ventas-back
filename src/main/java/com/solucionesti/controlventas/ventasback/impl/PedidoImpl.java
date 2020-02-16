package com.solucionesti.controlventas.ventasback.impl;

import com.solucionesti.controlventas.ventasback.domains.Pedido;
import com.solucionesti.controlventas.ventasback.repositories.IPedidoDao;
import com.solucionesti.controlventas.ventasback.services.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoImpl implements IPedidoService {

    @Autowired
    private IPedidoDao objDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> getAll() {
        return (List<Pedido>) objDao.findAll();
    }

    @Override
    public Pedido getId(Long id) {
        return objDao.findById(id).orElse(null);
    }

    @Override
    public Pedido create(Pedido obj) {
        return objDao.save(obj);
    }

    @Override
    public void delete(Long id) {
        objDao.deleteById(id);
    }

    @Override
    public List<Pedido> getActivos() {
        return objDao.verPedidosActivos();
    }


}
