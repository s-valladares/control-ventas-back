package com.solucionesti.controlventas.ventasback.repositories;

import com.solucionesti.controlventas.ventasback.domains.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoDao extends JpaRepository<Pedido, Long> {

}
