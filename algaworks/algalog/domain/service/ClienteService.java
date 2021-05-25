package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class ClienteService {
	
	 @Autowired
	    private ClienteRepository clienteRepository;

	    public Collection<Cliente> getAll() {
	        return clienteRepository.findAll();
	    }

	    @Transactional
	    public Cliente salvar(Cliente cliente) {
	        boolean emailJaExiste = clienteRepository.findByEmail(cliente.getEmail()).stream()
	                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

	        if (emailJaExiste) {
	            throw new NegocioException("Informe outro email e tente novamente. E-mail já registrado!");
	        }

	        return clienteRepository.save(cliente);
	    }

	    public Cliente buscar(Long id) {
	        return clienteRepository
	                .findById(id)
	                .orElseThrow(() -> new NegocioException("Cliente não encontrado."));
	    }

	    public boolean naoExisteCliente(Long id) {
	        return !clienteRepository.existsById(id);
	    }

	    @Transactional
	    public void removerCliente(Long id) {
	        clienteRepository.deleteById(id);
	    }

}
