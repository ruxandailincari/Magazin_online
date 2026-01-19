CREATE INDEX idx_active_products
ON products(stock)
WHERE stock>0;