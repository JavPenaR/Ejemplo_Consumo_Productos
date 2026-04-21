package cl.duoc.venta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duoc.venta.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {

}
