
package com.siham.guidetoristique.models;

public class CategoryModel {
    private String name;
    private String description;
    private int imageResId;
    private String type;
    public CategoryModel(String name, String description, int imageResId, String type) {
        this.name = name;
        this.description = description;
        this.imageResId = imageResId;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getImageResId() {
        return imageResId;
    }
    public String getType() {
        return type;
    }
}
