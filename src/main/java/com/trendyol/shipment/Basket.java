package com.trendyol.shipment;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Basket {

    private static final int THRESHOLD_SIZE = 3;
    private List<Product> products;

    public ShipmentSize getShipmentSize() {
        ShipmentSize largestSize = null;

        int countOfLargestSize = 0;
        for (Product product : products) {
            ShipmentSize size = product.getSize();
            if (largestSize == null || size.ordinal() > largestSize.ordinal()) {
                largestSize = size;
                countOfLargestSize = 1;
            } else if (size.equals(largestSize)) {
                countOfLargestSize++;
            }
        }

        if (countOfLargestSize >= THRESHOLD_SIZE) {
            return ShipmentSize.values()[largestSize.ordinal() + 1];
        } else {
            return largestSize;
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
