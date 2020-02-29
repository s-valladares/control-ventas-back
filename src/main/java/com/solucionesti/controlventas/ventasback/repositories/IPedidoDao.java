package com.solucionesti.controlventas.ventasback.repositories;

import com.solucionesti.controlventas.ventasback.domains.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPedidoDao extends JpaRepository<Pedido, Long> {

    // Mostrar pedidos activos
    @Query("SELECT p FROM Pedido p WHERE p.estado = true")
    List<Pedido> verPedidosActivos();

    // Mostrar pedidos que pertenecen a cierta semana de venta
    @Query("SELECT p FROM Pedido p WHERE  p.ventaSemana.id = ?1")
    List<Pedido> verPedidosSemanaVenta(Long idSemanaVenta);

}
