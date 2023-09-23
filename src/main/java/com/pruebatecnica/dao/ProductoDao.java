package com.pruebatecnica.dao;

import com.pruebatecnica.entidades.Producto;
import java.util.List;

/**
 *
 * @author jejacobo
 */
public interface ProductoDao {
    public void saveProducto(Producto producto);
    public Producto findProductoById(Producto producto);
    public Producto findProductoByName(Producto producto);
    public List<Producto> findAllProductos();
    public void updateProducto(Producto producto);
    public void deleteProducto(Producto Producto);
}
