package com.pruebatecnica.dao;

import com.pruebatecnica.entidades.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jejacobo
 */
@Stateless
public class ProductoDaoImpl implements ProductoDao{
    
    @PersistenceContext(unitName = "productoPU")
    private EntityManager em;
    
    @Override
    public void saveProducto(Producto producto) {
        em.persist(producto);
    }

    @Override
    public Producto findProductoById(Producto producto) {
        return (Producto) em.createNamedQuery("Producto.findById").setParameter("idProducto", producto.getIdProducto()).getSingleResult();
    }
    
    @Override
    public Producto findProductoByName(Producto producto) {
        return (Producto) em.createNamedQuery("Producto.findByNombre").setParameter("nombre", producto.getNombre()).getSingleResult();
    }

    @Override
    public List<Producto> findAllProductos() {
        return em.createNamedQuery("Producto.findAll").getResultList();
    }

    @Override
    public void updateProducto(Producto producto) {
        em.merge(producto);
    }

    @Override
    public void deleteProducto(Producto producto) {
        em.remove(em.merge(producto));
    }
    
}
