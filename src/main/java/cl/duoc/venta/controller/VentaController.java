package cl.duoc.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.venta.model.Venta;
import cl.duoc.venta.service.VentaService;

@RestController
@RequestMapping("/api/v0/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping
    public void realizarVenta(@RequestBody Venta venta) {
        ventaService.realizarVenta(venta);
    }

    @GetMapping("/{id}/total")
    public Double calcularTotalVenta(@PathVariable Long id) {
        Venta venta = ventaService.obtenerVentaPorId(id);
        return ventaService.calcularTotalVenta(venta);
    }

}
