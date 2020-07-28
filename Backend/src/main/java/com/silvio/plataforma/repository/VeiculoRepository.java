package com.silvio.plataforma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silvio.plataforma.model.Marca;
import com.silvio.plataforma.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	List<Veiculo> findAllByModelo(String modelo);
	List<Veiculo> findAllByMarca(Marca marca);
}
