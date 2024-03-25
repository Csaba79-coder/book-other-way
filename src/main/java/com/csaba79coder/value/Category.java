package com.csaba79coder.value;

public enum Category {
    NOVEL("regény"),
    NON_FICTION("ismeretterjesztő"),
    FAIRY_TALE("mese"),
    ADVENTURE_NOVEL("kalandregény"),
    ROMANTIC("romantikus"),
    YOUTH_NON_FICTION("ifjúsági ismeretterjesztő"),
    YOUTH_NOVEL("ifjúsági kisregény"),
    SCIENCE_FICTION("sci-fi"),
    AUTOBIOGRAPHY("önéletrajzi"),
    CRIME("krimi"),
    UNKNOWN("N/A");

    private final String HUNGARIAN_NAME;

    Category(String HUNGARIAN_NAME) {
        this.HUNGARIAN_NAME = HUNGARIAN_NAME ;
    }

    public String getHungarianName() {
        return HUNGARIAN_NAME;
    }
}
