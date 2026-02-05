package com.konkiburger.user.service;

import com.konkiburger.user.model.entity.Entidad;
import com.konkiburger.user.repository.CRUDRepository;
import com.konkiburger.user.repository.GenericRepository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class GenericServiceImpl<T extends Entidad> implements RepositoryService<T>{
    private EntityManager em;
    private CRUDRepository<T> repositorio;

    public GenericServiceImpl() {
    }

    public GenericServiceImpl(EntityManager em) {
        this.em = em;
        this.repositorio = new GenericRepository<>(em);
    }

    @Override
    public List<T> listar(Class<T> clase) {
        return repositorio.listar(clase);
    }

    @Override
    public Optional<T> porId(Class<T> clase, Integer id) {
        return Optional.ofNullable(repositorio.porId(clase, id));
    }

    @Override
    public void guardar(T t) {
        try{
            em.getTransaction().begin();
            repositorio.guardar(t);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Class<T> clase, Integer id) {
        try{
            em.getTransaction().begin();
            repositorio.eliminar(clase, id);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    /**
     * Busca una entidad específica dentro de la lista de todas las entidades de la clase.
     * Compara por ID en lugar de compareTo.
     *
     * @param t     La entidad a buscar
     * @param clase La clase de la entidad
     * @return Optional de la entidad encontrada o vacío si no existe
     */
    @Override
    public Optional<T> buscarEntidad(T t, Class<T> clase) {
        if (t.getId() != null) {
            return porId(clase, t.getId());
        }
        List<T> entidades = repositorio.listar(clase);
        for (T entidadTemporal : entidades) {
            if (t.equals(entidadTemporal)) {
                return Optional.of(entidadTemporal);
            }
        }
        return Optional.empty();
    }
}
