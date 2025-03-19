package com.example.operational_transform.dto;

public class ChangeDTO {
    private RangeDTO range;
    private int rangeLength;
    private String text;
    private int rangeOffset;
    private boolean forceMoveMarkers;

    // Getters and Setters
    public RangeDTO getRange() {
        return range;
    }

    public void setRange(RangeDTO range) {
        this.range = range;
    }

    public int getRangeLength() {
        return rangeLength;
    }

    public void setRangeLength(int rangeLength) {
        this.rangeLength = rangeLength;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRangeOffset() {
        return rangeOffset;
    }

    public void setRangeOffset(int rangeOffset) {
        this.rangeOffset = rangeOffset;
    }

    public boolean isForceMoveMarkers() {
        return forceMoveMarkers;
    }

    public void setForceMoveMarkers(boolean forceMoveMarkers) {
        this.forceMoveMarkers = forceMoveMarkers;
    }
    
}