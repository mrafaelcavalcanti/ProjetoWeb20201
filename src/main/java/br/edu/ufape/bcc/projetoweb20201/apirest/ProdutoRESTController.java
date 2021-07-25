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

import br.edu.ufape.bcc.projetoweb20201.model.Produto;
import br.edu.ufape.bcc.projetoweb20201.repository.ProdutoDAOI;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoRESTController {
    @Autowired
    ProdutoDAOI produtoDAOI;

    @GetMapping
    @RequestMapping("/get/all")
    public List<Produto> findAllProdutos() {
        return produtoDAOI.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable("id") Long id) {
        
        Optional<Produto> optProduto = produtoDAOI.findById(id);
        if (optProduto.isPresent()) {
            Produto produto = optProduto.get();
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        }
        
        return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getByName/{name}")
    public List<Produto> getProdutoByName(@PathVariable("name") String name) {
        String n = name;
        System.out.println(n);
        return produtoDAOI.findByName(name);
    }

    @GetMapping("/getByCategoria/{categoria}")
    public List<Produto> getPrdutoByCategoria(@PathVariable("categoria") int categoria) {
        return produtoDAOI.findByCategoria(categoria);
    }

    @GetMapping("/getByUserProducts/{id}")
    public List<Produto> getPrdutoByUserProducts(@PathVariable("id") Long id) {
        return produtoDAOI.findByUserProducts(id);
    }

    

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto addProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoDAOI.save(produto);
        return novoProduto;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto) {
        Optional<Produto> optProduto = produtoDAOI.findById(produto.getId());
        if (optProduto.isPresent()) {
            produtoDAOI.save(produto);
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        }
        return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deleteProduto(@PathVariable("id") Long id) {
        Optional<Produto> optUsario = produtoDAOI.findById(id);
        if (optUsario.isPresent()) {
            Produto produto = optUsario.get();
            produtoDAOI.delete(produto);
            return new ResponseEntity<Produto>(HttpStatus.OK);
        }
        return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
    }
}
