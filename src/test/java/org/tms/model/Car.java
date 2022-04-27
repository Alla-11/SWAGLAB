package org.tms.model;

import lombok.*;


@Data // getter, setter, to string, hashcode, equals
@AllArgsConstructor  //заменяет всех типов конструктора для всех полей
@NoArgsConstructor // пустой конструктор
@Builder

public class Car {

    private String brand;
    private String  model;
    private String color;


}
