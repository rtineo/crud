package curso.docker.crud.product.controller;
import curso.docker.crud.product.model.Producto;
import curso.docker.crud.product.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public Optional<Producto> getProductoById(@PathVariable int id) {
        return productoService.getProductoById(id);
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable int id, @RequestBody Producto producto) {
        producto.setId(id);
        return productoService.saveProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable int id) {
        productoService.deleteProducto(id);
    }
}
