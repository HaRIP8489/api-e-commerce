CREATE TABLE products (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          user_id BIGINT NOT NULL,
                          name VARCHAR(100) NOT NULL,
                          price_per_day DECIMAL(10,2) NOT NULL,
                          quantity INT DEFAULT 1,
                          view_count INT DEFAULT 0,
                          sold_count INT DEFAULT 0,
                          status ENUM('available', 'unavailable', 'rented', 'pending_approval') DEFAULT 'pending_approval',
                          created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                          updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                          FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE orders (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        renter_id BIGINT NOT NULL,
                        owner_id BIGINT NOT NULL,
                        total_price DECIMAL(10,2),
                        status ENUM('pending', 'confirmed', 'cancelled', 'completed') DEFAULT 'pending',
                        rent_start DATE,
                        rent_end DATE,
                        created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                        updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        FOREIGN KEY (renter_id) REFERENCES users(user_id),
                        FOREIGN KEY (owner_id) REFERENCES users(user_id)
);

CREATE TABLE order_items (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             order_id INT,
                             product_id INT,
                             owner_id BIGINT,
                             quantity INT,
                             price_per_day DECIMAL(10,2),
                             rent_start DATE,
                             rent_end DATE,
                             total_price DECIMAL(10,2),
                             FOREIGN KEY (order_id) REFERENCES orders(id),
                             FOREIGN KEY (product_id) REFERENCES products(id),
                             FOREIGN KEY (owner_id) REFERENCES users(user_id)
);

CREATE TABLE cart_items (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            user_id BIGINT NOT NULL,
                            product_id INT NOT NULL,
                            owner_id BIGINT NOT NULL,
                            quantity INT DEFAULT 1,
                            price_per_day DECIMAL(10,2) NOT NULL,
                            rent_start DATE,
                            rent_end DATE,
                            created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                            updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                            FOREIGN KEY (user_id) REFERENCES users(user_id),
                            FOREIGN KEY (product_id) REFERENCES products(id),
                            FOREIGN KEY (owner_id) REFERENCES users(user_id)
);
