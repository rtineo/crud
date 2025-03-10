package curso.docker.crud.product.controller;
import curso.docker.crud.product.model.Producto;
import curso.docker.crud.product.service.ProductoService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    protected static final Logger logger = LogManager.getLogger();
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        logger.info("Se trajo lista de productos del h2");
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public Optional<Producto> getProductoById(@PathVariable("id") int id) {
        return productoService.getProductoById(id);
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        logger.info("Se grabo datos de nuevo producto");
        return productoService.saveProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable("id") int id, @RequestBody Producto producto) {
        producto.setId(id);
        logger.info("Se actualizo producto:"+id+"-"+producto.getNombre());
        return productoService.saveProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable("id") int id) {
        logger.info("Se borro producto:"+id);
        productoService.deleteProducto(id);
    }
}
