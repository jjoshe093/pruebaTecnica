package com.pruebatecnica.service;

import com.pruebatecnica.entidades.Producto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jejacobo
 */
@Local
public interface ProductoService {
    public void saveProducto(Producto producto);
    public Producto findProductoById(Producto producto);
    public Producto findProductoByName(Producto producto);
    public List<Producto> findAllProductos();
    public void updateProducto(Producto producto);
    public void deleteProducto(Producto Producto);
}
