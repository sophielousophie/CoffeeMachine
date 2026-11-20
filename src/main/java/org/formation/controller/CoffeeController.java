package org.formation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.formation.dto.CoffeeCreateDto;
import org.formation.dto.CoffeeDto;
import org.formation.dto.CoffeeUpdateDto;
import org.formation.entity.Coffee;
import org.formation.repository.CoffeeRepository;
import org.formation.service.CoffeeService;
import org.formation.service.CoffeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("coffees")
@RequiredArgsConstructor // prend que les paramètres finaux
public class CoffeeController {
    private final CoffeeService service;

    @PostMapping
    CoffeeDto create(@RequestBody @Valid CoffeeCreateDto dto) {
        return service.create(dto);
    }

    @GetMapping
    List<CoffeeDto> coffees(){

        
        return service.allCoffees();
    }

    @GetMapping("{id}") /// variable du chemin
    ResponseEntity<CoffeeDto> coffee(@PathVariable Long id){/// Au lieu de Optional
        return service.oneCoffee(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
                ///.map(coffee ->  ResponseEntity.ok(coffee)); Autre possibilité
    }

    @PatchMapping("{id}") /// variable du chemin
    ResponseEntity<CoffeeDto> update(@PathVariable Long id, @RequestBody @Valid CoffeeUpdateDto dto){/// Au lieu de Optional
        return service.update(id, dto)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        ///.map(coffee ->  ResponseEntity.ok(coffee)); Autre possibilité
    }

}
