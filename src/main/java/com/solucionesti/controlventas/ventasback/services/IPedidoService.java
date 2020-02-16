package com.solucionesti.controlventas.ventasback.services;

import com.solucionesti.controlventas.ventasback.domains.Pedido;

import java.util.List;

public interface IPedidoService {
    public List<Pedido> getAll();
    public Pedido getId(Long id);
    public Pedido create(Pedido p);
    public void delete(Long id);
}
