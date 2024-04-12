package com.springbootproject.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
	private Integer categoryIdInteger;
	@NotBlank
	@Size(min = 4,message = "minimum size of category description is 10")
	private String categoryTitle;
	@NotBlank
	@Size(min = 10,message = "minimum size of category description is 10")
	private String categoryDescription;
}
