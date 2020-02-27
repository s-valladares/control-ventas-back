package com.solucionesti.controlventas.ventasback.repositories;

import com.solucionesti.controlventas.ventasback.domains.Egreso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEgresoDao extends JpaRepository<Egreso, Long> {


}
