package com.bioarktech.service.impl;

import com.bioarktech.model.CarouselItem;
import com.bioarktech.service.CarouselService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 轮播图服务实现类
 * <p>
 * 实现CarouselService接口，提供轮播图数据的业务逻辑处理
 * 当前使用内存中的模拟数据，实际生产环境中应替换为数据库存储
 * </p>
 * 
 * @author BioArk Team
 */
@Service
public class CarouselServiceImpl implements CarouselService {
    
    /**
     * 轮播图数据存储集合
     * 使用final修饰确保集合引用不可变，提高线程安全性
     * ArrayList用于高效的随机访问，适合轮播图场景
     */
    private final List<CarouselItem> carouselItems = new ArrayList<>();
    
    /**
     * 构造函数，初始化轮播图数据
     * <p>
     * 在服务初始化时预加载轮播图数据
     * 实际项目中可替换为从数据库、配置文件或远程API加载
     * </p>
     */
    public CarouselServiceImpl() {
        // 初始化第一张轮播图 - 基因创新主题
        carouselItems.add(new CarouselItem(
            1L,
            "Genetic Innovation",                    // 主标题
            "Innovative seed on board",              // 副标题
            "/static/images/carousel1.jpg",          // 图片路径
            "Explore Services",                      // 按钮文字
            "/services",                             // 按钮链接
            "Your trusted CRO partner for advanced gene editing and delivery solutions, accelerating research from discovery to therapy."
        ));
        
        carouselItems.add(new CarouselItem(
            2L,
            "Advanced Gene Editing",
            "Precision tools for your research",
            "/static/images/carousel2.jpg",
            "View Products",
            "/products",
            "Comprehensive portfolio of gene editing tools designed to accelerate your research and deliver reliable results."
        ));
        
        carouselItems.add(new CarouselItem(
            3L,
            "Expert CRO Services",
            "Tailored solutions for your projects",
            "/static/images/carousel3.jpg",
            "Contact Us",
            "/contact",
            "Partner with our expert team for customized services that meet your unique research requirements."
        ));
    }

    /**
     * 获取所有轮播图数据
     * 
     * @return 轮播图列表
     */
    @Override
    public List<CarouselItem> getAllCarouselItems() {
        return new ArrayList<>(carouselItems);
    }

    /**
     * 根据ID获取轮播图数据
     * 
     * @param id 轮播图ID
     * @return 轮播图对象，如果不存在返回null
     */
    @Override
    public CarouselItem getCarouselItemById(Long id) {
        Optional<CarouselItem> optionalItem = carouselItems.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
        return optionalItem.orElse(null);
    }
}