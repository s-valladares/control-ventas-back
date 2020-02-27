package com.solucionesti.controlventas.ventasback.impl;

import com.solucionesti.controlventas.ventasback.domains.VentaSemana;
import com.solucionesti.controlventas.ventasback.repositories.IVentaSemanaDao;
import com.solucionesti.controlventas.ventasback.services.IVentaSemanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentaSemanaImpl implements IVentaSemanaService {

    @Autowired
    private IVentaSemanaDao objDao;

    @Override
    @Transactional(readOnly = true)
    public List<VentaSemana> getAll() {
        return (List<VentaSemana>) objDao.findAll();
    }

    @Override
    public VentaSemana getId(Long id) {
        return objDao.findById(id).orElse(null);
    }

    @Override
    public VentaSemana create(VentaSemana obj) {
        return objDao.save(obj);
    }

    @Override
    public void delete(Long id) {
        objDao.deleteById(id);
    }



}
