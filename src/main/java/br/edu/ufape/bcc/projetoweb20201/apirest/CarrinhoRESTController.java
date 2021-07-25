package br.edu.ufape.bcc.projetoweb20201.apirest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.bcc.projetoweb20201.model.Carrinho;
import br.edu.ufape.bcc.projetoweb20201.repository.CarrinhoDAOI;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoRESTController {
    
    @Autowired
    CarrinhoDAOI carrinhoDAOI;

    @GetMapping("/getById/{id}")
    public List<Carrinho> getCarrinhoById(@PathVariable("id") Long id) {
        return carrinhoDAOI.findByUserId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carrinho addCarrinho(@RequestBody Carrinho carrinho) {
        Carrinho adicionarCarrinho = carrinhoDAOI.save(carrinho);
        return adicionarCarrinho;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Carrinho> updateCarrinho(@RequestBody Carrinho carrinho) {
        Optional<Carrinho> optCarrinho = carrinhoDAOI.findById(carrinho.getId());
        if(optCarrinho.isPresent()) {
            carrinhoDAOI.save(carrinho);
            return new ResponseEntity<Carrinho>(carrinho, HttpStatus.OK);
        }
        return new ResponseEntity<Carrinho>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Carrinho> deleteCarrinho(@PathVariable("id") Long id) {
        Optional<Carrinho> optCarrinho = carrinhoDAOI.findById(id);
        if(optCarrinho.isPresent()) {
            Carrinho carrionho = optCarrinho.get();
            carrinhoDAOI.delete(carrionho);
            return new ResponseEntity<Carrinho>(HttpStatus.OK);
        }
        return new ResponseEntity<Carrinho>(HttpStatus.NOT_FOUND);
    }
}
