package com.ras.waterpricing.repository;

import com.ras.waterpricing.model.TabelaTarifaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabelaTarifariaRepository extends JpaRepository<TabelaTarifaria, Long>{
    //busca custom se necessário
}