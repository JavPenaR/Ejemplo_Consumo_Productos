package cl.duoc.venta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import cl.duoc.venta.dto.ProductoDTO;
import cl.duoc.venta.model.Venta;
import cl.duoc.venta.repository.VentaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private WebClient webClient;

    public void realizarVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    public Double calcularTotalVenta(Venta venta) {
        ProductoDTO producto = webClient.get()
                                        .uri("/api/v0/productos/{id}", venta.getProductoId())
                                        .retrieve()
                                        .bodyToMono(ProductoDTO.class)
                                        .block();

        return producto.getPrecio() * venta.getCantidad();
    }

    public Venta obtenerVentaPorId(Long id) {
        return ventaRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }


}
