package com.solucionesti.controlventas.ventasback.repositories;

import com.solucionesti.controlventas.ventasback.domains.ProductoTipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoTipoDao extends JpaRepository<ProductoTipo, Long> {

}
