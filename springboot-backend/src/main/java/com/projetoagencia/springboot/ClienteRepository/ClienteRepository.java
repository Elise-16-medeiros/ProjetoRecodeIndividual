package com.projetoagencia.springboot.ClienteRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoagencia.springboot.ClienteModel.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
