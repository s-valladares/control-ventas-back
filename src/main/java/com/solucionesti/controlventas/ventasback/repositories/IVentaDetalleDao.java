package com.solucionesti.controlventas.ventasback.repositories;

import com.solucionesti.controlventas.ventasback.domains.VentaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IVentaDetalleDao extends JpaRepository<VentaDetalle, Long> {

    // Mostrar detalles de venta por id de venta
    @Query("SELECT v FROM VentaDetalle v WHERE v.venta.id = ?1")
    List<VentaDetalle> verVentasDetallesId(Long id);


}
