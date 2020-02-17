package com.solucionesti.controlventas.ventasback.services;

import com.solucionesti.controlventas.ventasback.domains.Pedido;
import com.solucionesti.controlventas.ventasback.domains.PedidoDetalle;

import java.util.List;

public interface IPedidoDetalleService {

    public PedidoDetalle getId(Long id);
    public PedidoDetalle create(PedidoDetalle p);
    public void delete(Long id);

    public List<PedidoDetalle> getIdPedido(Long id);
}
