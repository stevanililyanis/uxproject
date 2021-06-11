package com.uxfinalproject.wrcomic.model;

public class comic {
    private String comic_name, desc_comic;
    private Integer comic_image;

    public comic(String comic_name, String desc_comic, Integer comic_image) {
        this.comic_name = comic_name;
        this.desc_comic=desc_comic;
        this.comic_image= comic_image;
    }

    public String getComic_name() {
        return comic_name;
    }

    public void setComic_name(String comic_name) {
        this.comic_name = comic_name;
    }

    public String getDesc_comic() {
        return desc_comic;
    }

    public void setDesc_comic(String desc_comic) {
        this.desc_comic = desc_comic;
    }

    public Integer getComic_image() {
        return comic_image;
    }

    public void setComic_image(Integer comic_image) {
        this.comic_image = comic_image;
    }
}
