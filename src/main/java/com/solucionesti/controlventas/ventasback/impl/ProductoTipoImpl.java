package com.solucionesti.controlventas.ventasback.impl;


import com.solucionesti.controlventas.ventasback.domains.ProductoTipo;
import com.solucionesti.controlventas.ventasback.repositories.IProductoTipoDao;
import com.solucionesti.controlventas.ventasback.services.IProductoTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoTipoImpl implements IProductoTipoService {

    @Autowired
    private IProductoTipoDao objDao;

    @Override
    @Transactional(readOnly = true)
    public List<ProductoTipo> getAll() {
        return (List<ProductoTipo>) objDao.findAll();
    }

    @Override
    public ProductoTipo getId(Long id) {
        return objDao.findById(id).orElse(null);
    }

}
