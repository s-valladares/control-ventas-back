package com.solucionesti.controlventas.ventasback.impl;

import com.solucionesti.controlventas.ventasback.domains.Egreso;
import com.solucionesti.controlventas.ventasback.repositories.IEgresoDao;
import com.solucionesti.controlventas.ventasback.services.IEgresoService;
import com.solucionesti.controlventas.ventasback.services.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EgresoImpl implements IEgresoService {

    @Autowired
    private IEgresoDao objDao;

    @Override
    @Transactional(readOnly = true)
    public List<Egreso> getAll() {
        return (List<Egreso>) objDao.findAll();
    }

    @Override
    public Egreso getId(Long id) {
        return objDao.findById(id).orElse(null);
    }

    @Override
    public Egreso create(Egreso obj) {
        return objDao.save(obj);
    }

    @Override
    public void delete(Long id) {
        objDao.deleteById(id);
    }



}
