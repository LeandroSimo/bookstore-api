package com.leandro.bookstore.dtos;


import com.leandro.bookstore.domain.Category;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "The NAME field is required")
    @Length(min = 3, max = 100, message = "The NAME field must be between 3 and 100 characters")
    private String name;
    @NotEmpty(message = "The DESCRIPTION field is required")
    @Length(min = 3, max = 200, message = "The DESCRIPTION field must be between 3 and 200 characters")
    private String description;

    public CategoryDto() {
    }

    public CategoryDto(Category categoryDto) {
        this.id = categoryDto.getId();
        this.name = categoryDto.getName();
        this.description = categoryDto.getDescription();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
