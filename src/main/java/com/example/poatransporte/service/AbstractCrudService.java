package com.example.poatransporte.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;


@Transactional(readOnly = true)
public abstract class AbstractCrudService<ENTITY> {

    protected abstract JpaRepository<ENTITY, Long> getRepository();

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ENTITY save(@NotNull @Valid ENTITY entity){
        return getRepository().save(entity);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void delete(Long id) {
        getRepository().deleteById(id);
    }

    public Optional<ENTITY> findById(Long id){
        return getRepository().findById(id);
    }

    public List<ENTITY> findAll() {
        return getRepository().findAll();
    }
}
