package com.solucionesti.controlventas.ventasback.impl;

import com.solucionesti.controlventas.ventasback.domains.Producto;
import com.solucionesti.controlventas.ventasback.repositories.IProductoDao;
import com.solucionesti.controlventas.ventasback.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoImpl implements IProductoService {

    @Autowired
    private IProductoDao objDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getAll() {
        return (List<Producto>) objDao.findAll();
    }

    @Override
    public Producto getId(Long id) {
        return objDao.findById(id).orElse(null);
    }

    @Override
    public Producto create(Producto obj) {
        return objDao.save(obj);
    }

    @Override
    public void delete(Long id) {
        objDao.deleteById(id);
    }
}
