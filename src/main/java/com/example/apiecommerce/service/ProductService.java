package com.example.apiecommerce.service;

import com.example.apiecommerce.model.Product;
import com.example.apiecommerce.model.ProductDetail;
import com.example.apiecommerce.repository.ProductDetailRepository;
import com.example.apiecommerce.repository.ProductRepository;
import com.example.apiecommerce.dto.ProductDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDetailRepository productDetailRepository;

    // Lấy tất cả sản phẩm hoặc theo status
    public List<Product> getAllAvailableProducts() {
        return productRepository.findByStatus(Product.Status.available);
    }

    public Optional<ProductDetailDTO> getProductDetailById(Integer productId) {
        Optional<Product> productOpt = productRepository.findById(productId);
        if (productOpt.isPresent()) {
            Optional<ProductDetail> detailOpt = productDetailRepository.findByProductId(productId);
            ProductDetail detail = detailOpt.orElse(null);
            return Optional.of(new ProductDetailDTO(productOpt.get(), detail));
        }
        return Optional.empty();
    }
}
