package home.service;

import home.entity.Product;
import home.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl {
    
    private final ProductRepository repo;
    
    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }
    
    public List<Product> listAll() {
        return repo.findAll();
    }
    
    public Product save(Product product) {
        return repo.save(product);
    }
    
    public Product get(Long id) {
        return repo.findById(id).orElse(null);
    }
    
    public void delete(Long id) {
        repo.deleteById(id);
    }
}