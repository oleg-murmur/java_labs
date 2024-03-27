package com.example.demo;

import lombok.Getter;
public class Screw {
	@Getter private String name; //Вид винта
	@Getter private String material; //Материал
	@Getter private String head; //Головка
	@Getter private float height;//Высота
	@Getter private float price;//Цена

	public Screw(String name, String material, String head, float height, float price) {
		this.name = name;
		this.material = material;
		this.head = head;
		this.height = height;
		this.price = price;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj==null || getClass()!=obj.getClass()) return false;
		Screw screw = (Screw) obj;
		if(!name.equals(screw.name)) return false;
		if(!material.equals(screw.material)) return false;
		if(!head.equals(screw.head)) return false;
		if(height != screw.height) return false;
		return price == screw.price;
		
	}
	@Override
	public int hashCode() {
		int result = (int) ((int)price ^ ((int)price >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + material.hashCode();
        result = 31 * result + head.hashCode();
        result = 31 * result + (int) height;
        return result;
	}
}
