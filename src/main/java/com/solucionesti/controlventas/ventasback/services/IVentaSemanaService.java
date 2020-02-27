package com.solucionesti.controlventas.ventasback.services;

import com.solucionesti.controlventas.ventasback.domains.VentaSemana;

import java.util.List;

public interface IVentaSemanaService {
    List<VentaSemana> getAll();
    VentaSemana getId(Long id);
    VentaSemana create(VentaSemana p);
    void delete(Long id);


}
