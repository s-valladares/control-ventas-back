package com.solucionesti.controlventas.ventasback.services;

import com.solucionesti.controlventas.ventasback.domains.Pedido;

import java.util.List;

public interface IPedidoService {
    List<Pedido> getAll();
    Pedido getId(Long id);
    Pedido create(Pedido p);
    void delete(Long id);

    List<Pedido> getActivos();
    List<Pedido> getPedidosSemana(Long idSemanaVenta);
}
