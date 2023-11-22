package com.proyecto01.dev.infrastracture;

import com.proyecto01.dev.domain.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CompraRepository extends JpaRepository<Compra,Long> {
}

