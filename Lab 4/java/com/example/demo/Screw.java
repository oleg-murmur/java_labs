package com.example.demo;

import lombok.Getter;

public class Screw {
    @Getter private String name;// Вид винта

    @Getter private String material;// Материал

    @Getter private String head;// Головка

    @Getter private String height;// Высота
    @Getter private int amount;//Цена
    @Getter private int id;

    public Screw(String name, String material, String head, String height, int amount, int id) {
        this.name = name;
        this.material = material;
        this.head = head;
        this.height = height;
        this.amount = amount;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        Screw screws = (Screw) obj;
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!name.equals(screws.name)) return false;
        if (!material.equals(screws.material)) return false;
        if (!head.equals(screws.head)) return false;
        if (!height.equals(screws.height)) return false;
        if (id != screws.id) return false;
        return amount == screws.amount;
    }

    @Override
    public int hashCode() {
        int result = (int) (amount ^ (amount >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + material.hashCode();
        result = 31 * result + head.hashCode();
        result = 31 * result + height.hashCode();
        result = 31 * result + id;
        return result;
    }
}