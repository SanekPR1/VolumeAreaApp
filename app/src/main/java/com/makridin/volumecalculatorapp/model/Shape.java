package com.makridin.volumecalculatorapp.model;

public class Shape {
    private int shapeImage;
    private String shapeName;

    public Shape(int shapeImage, String shapeName) {
        this.shapeImage = shapeImage;
        this.shapeName = shapeName;
    }

    public int getShapeImage() {
        return shapeImage;
    }

    public String getShapeName() {
        return shapeName;
    }
}
