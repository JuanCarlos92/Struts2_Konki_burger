package com.konkiburger.user.repository;

import com.konkiburger.user.model.entity.Entidad;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GenericRepository<T extends Entidad> implements CRUDRepository<T>{
    private EntityManager em;
    public GenericRepository(EntityManager em) {this.em = em;}

    @Override
    public List<T> listar(Class<T> clase) {
        return em.createQuery("select t from "+ clase.getSimpleName() +" t").getResultList();
    }

    @Override
    public T porId(Class<T> clase, Integer id) {
        return em.find(clase, id);
    }

    @Override
    public void guardar(T t) {
        if(t.getId()!=null&&t.getId()>0){
            em.merge(t);
        }else{
            em.persist(t);
        }
    }

    @Override
    public void eliminar(Class<T> clase, Integer id) {
        em.remove(porId(clase, id));
    }
}
