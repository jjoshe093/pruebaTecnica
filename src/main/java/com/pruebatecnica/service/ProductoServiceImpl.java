package com.pruebatecnica.service;

import com.pruebatecnica.dao.ProductoDao;
import com.pruebatecnica.entidades.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jejacobo
 */
@Stateless
public class ProductoServiceImpl implements ProductoService{
    
    @Inject
    ProductoDao productoDao;
    
    @Override
    public void saveProducto(Producto producto) {
        productoDao.saveProducto(producto);
    }

    @Override
    public Producto findProductoById(Producto producto) {
        return productoDao.findProductoById(producto);
    }

    @Override
    public Producto findProductoByName(Producto producto) {
        return productoDao.findProductoByName(producto);
    }

    @Override
    public List<Producto> findAllProductos() {
        return productoDao.findAllProductos();
    }

    @Override
    public void updateProducto(Producto producto) {
        productoDao.updateProducto(producto);
    }

    @Override
    public void deleteProducto(Producto Producto) {
        productoDao.deleteProducto(Producto);
    }
    
}
