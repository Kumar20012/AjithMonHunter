package com.tatacliq.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@EqualsAndHashCode
public class OrderPetStore {
        public int id;
        public int petId;
        public int quantity;
        public Date shipDate;
        public String status;
        public boolean complete;
}
