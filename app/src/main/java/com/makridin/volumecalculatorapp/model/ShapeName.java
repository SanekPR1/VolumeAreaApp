package com.makridin.volumecalculatorapp.model;

public enum ShapeName {
    SPHERE("Sphere"),
    CYLINDER("Cylinder"),
    CUBE("Cube"),
    PRISM("Prism");

    private String name;

    ShapeName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
