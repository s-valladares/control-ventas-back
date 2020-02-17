package com.solucionesti.controlventas.ventasback.repositories;

import com.solucionesti.controlventas.ventasback.domains.PedidoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPedidoDetalleDao extends JpaRepository<PedidoDetalle, Long> {

    // Mostrar detalles de pedidos por id de pedido
    @Query("SELECT p FROM PedidoDetalle p WHERE p.pedido.id = ?1")
    List<PedidoDetalle> verPedidosDetallesId(Long id);

}
