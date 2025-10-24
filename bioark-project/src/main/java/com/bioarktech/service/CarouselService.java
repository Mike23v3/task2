package com.bioarktech.service;

import com.bioarktech.model.CarouselItem;
import java.util.List;

/**
 * 轮播图服务接口
 * <p>
 * 提供轮播图数据的获取服务
 * </p>
 * 
 * @author BioArk Team
 */
public interface CarouselService {
    
    /**
     * 获取所有轮播图数据
     * 
     * @return 轮播图列表
     */
    List<CarouselItem> getAllCarouselItems();
    
    /**
     * 根据ID获取轮播图数据
     * 
     * @param id 轮播图ID
     * @return 轮播图对象，如果不存在返回null
     */
    CarouselItem getCarouselItemById(Long id);
}