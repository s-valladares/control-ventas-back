package com.solucionesti.controlventas.ventasback.repositories;
import com.solucionesti.controlventas.ventasback.domains.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVentaDao extends JpaRepository<Venta, Long> {

    // Mostrar ventas que pertenecen a cierta semana de venta
    @Query("SELECT v FROM Venta v WHERE  v.pedido.ventaSemana.id = ?1")
    List<Venta> verVentasPorSemanaVenta(Long idSemanaVenta);

}
