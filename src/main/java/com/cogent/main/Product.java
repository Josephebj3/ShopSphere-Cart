package com.cogent.main;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product
{
	private int id;
	private String name;
	private String description;
	private float price;
	private String category;
	private String image;
}

























