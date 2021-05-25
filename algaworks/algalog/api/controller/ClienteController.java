package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.mappers.ClienteMapper;
import com.algaworks.algalog.api.resources.ClienteResource;
import com.algaworks.algalog.domain.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	 @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public ResponseEntity<ClienteResource> adicionar(@Valid @RequestBody ClienteResource resource) {
	        var cliente = clienteService.salvar(clienteMapper.toEntity(resource));
	        return ResponseEntity.ok(clienteMapper.toResource(cliente));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<ClienteResource> atualizar(@Valid @PathVariable Long id,
	                                                     @RequestBody ClienteResource resource) {
	        if (clienteService.naoExisteCliente(id)) {
	            return ResponseEntity.notFound().build();
	        }

	        resource.setId(id);
	        var entity = clienteMapper.toEntity(resource);
	        var cliente = clienteService.salvar(entity);
	        return ResponseEntity.ok(clienteMapper.toResource(cliente));
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<ClienteResource> buscar(@PathVariable Long id) {
	        var cliente = clienteService.buscar(id);
	        return ResponseEntity.ok(clienteMapper.toResource(cliente));
	    }

	    @GetMapping()
	    public ResponseEntity<Collection<ClienteResource>> listar() {
	        return ResponseEntity.ok(clienteMapper.toCollection(clienteService.getAll()));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> remover(@PathVariable Long id) {
	        if (clienteService.naoExisteCliente(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        clienteService.removerCliente(id);

	        return ResponseEntity.noContent().build();
	    }

	    private ClienteMapper clienteMapper;
	    @Autowired
	    private ClienteService clienteService;
	
	

}
