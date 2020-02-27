package com.solucionesti.controlventas.ventasback.services;

import com.solucionesti.controlventas.ventasback.domains.Egreso;

import java.util.List;

public interface IEgresoService {
    public List<Egreso> getAll();
    public Egreso getId(Long id);
    public Egreso create(Egreso p);
    public void delete(Long id);

}
