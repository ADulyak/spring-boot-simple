package com.example.demo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    Long id;
    String name;
    Double price;

}
