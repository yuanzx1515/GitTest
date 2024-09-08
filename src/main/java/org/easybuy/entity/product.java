package org.easybuy.entity;

import lombok.Data;

@Data
public class product {
    int ID;
    String Name;
    String description;
    String image_url;
    double price;
}
