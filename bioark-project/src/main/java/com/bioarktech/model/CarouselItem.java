package com.bioarktech.model;

/**
 * 轮播图数据模型类
 * <p>
 * 用于存储首页轮播图的图片和对应的文本信息
 * </p>
 * 
 * @author BioArk Team
 */
public class CarouselItem {
    
    /** 轮播图ID */
    private Long id;
    
    /** 轮播图标题 */
    private String title;
    
    /** 轮播图副标题 */
    private String subtitle;
    
    /** 轮播图图片URL */
    private String imageUrl;
    
    /** 按钮文本 */
    private String buttonText;
    
    /** 按钮链接 */
    private String buttonLink;
    
    /** 轮播图描述 */
    private String description;

    /**
     * 构造函数
     */
    public CarouselItem() {
    }

    /**
     * 构造函数
     * 
     * @param id 轮播图ID
     * @param title 轮播图标题
     * @param subtitle 轮播图副标题
     * @param imageUrl 轮播图图片URL
     * @param buttonText 按钮文本
     * @param buttonLink 按钮链接
     * @param description 轮播图描述
     */
    public CarouselItem(Long id, String title, String subtitle, String imageUrl, 
                       String buttonText, String buttonLink, String description) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.imageUrl = imageUrl;
        this.buttonText = buttonText;
        this.buttonLink = buttonLink;
        this.description = description;
    }

    /**
     * 获取轮播图ID
     * 
     * @return 轮播图ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置轮播图ID
     * 
     * @param id 轮播图ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取轮播图标题
     * 
     * @return 轮播图标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置轮播图标题
     * 
     * @param title 轮播图标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取轮播图副标题
     * 
     * @return 轮播图副标题
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * 设置轮播图副标题
     * 
     * @param subtitle 轮播图副标题
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     * 获取轮播图图片URL
     * 
     * @return 轮播图图片URL
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 设置轮播图图片URL
     * 
     * @param imageUrl 轮播图图片URL
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 获取按钮文本
     * 
     * @return 按钮文本
     */
    public String getButtonText() {
        return buttonText;
    }

    /**
     * 设置按钮文本
     * 
     * @param buttonText 按钮文本
     */
    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    /**
     * 获取按钮链接
     * 
     * @return 按钮链接
     */
    public String getButtonLink() {
        return buttonLink;
    }

    /**
     * 设置按钮链接
     * 
     * @param buttonLink 按钮链接
     */
    public void setButtonLink(String buttonLink) {
        this.buttonLink = buttonLink;
    }

    /**
     * 获取轮播图描述
     * 
     * @return 轮播图描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置轮播图描述
     * 
     * @param description 轮播图描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CarouselItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", buttonText='" + buttonText + '\'' +
                ", buttonLink='" + buttonLink + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}