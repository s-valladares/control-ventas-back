package com.solucionesti.controlventas.ventasback.repositories;

import com.solucionesti.controlventas.ventasback.domains.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPedidoDao extends JpaRepository<Pedido, Long> {

    // Mostrar pedidos activos
    @Query("SELECT p FROM Pedido p WHERE p.estado = true")
    List<Pedido> verPedidosActivos();

}
