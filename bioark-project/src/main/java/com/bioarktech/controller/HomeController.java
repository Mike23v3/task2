package com.bioarktech.controller;

import com.bioarktech.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页控制器
 * <p>
 * 负责处理网站的主要页面请求，包括首页轮播图数据的加载和页面渲染
 * 实现了Spring MVC的控制器模式，提供多个页面路由
 * </p>
 * 
 * @author BioArk Team
 */
@Controller
public class HomeController {
    
    /**
     * 轮播图服务依赖
     * 使用final修饰确保不可变性，符合最佳实践
     */
    private final CarouselService carouselService;
    
    /**
     * 构造函数注入轮播图服务
     * <p>
     * 使用构造函数注入而非字段注入，提高可测试性和松耦合度
     * Spring 4.3+自动检测构造函数，@Autowired可省略
     * </p>
     * 
     * @param carouselService 轮播图服务实例，由Spring容器自动注入
     */
    @Autowired
    public HomeController(CarouselService carouselService) {
        this.carouselService = carouselService;
    }
    
    /**
     * 首页请求处理方法
     * <p>
     * 支持多个URL路径映射：空路径、根路径和/home路径
     * 从服务层获取轮播图数据并添加到Spring MVC模型中
     * 用于首页Thymeleaf模板渲染
     * </p>
     * 
     * @param model Spring MVC模型对象，用于传递数据到视图
     * @return 首页视图名称(home)，对应templates/home.html
     */
    @GetMapping(value = {"", "/", "/home"})
    public String home(Model model) {
        // 将轮播图数据添加到模型中
        model.addAttribute("carouselItems", carouselService.getAllCarouselItems());
        
        // 返回首页视图
        return "home";
    }
    
    /**
     * 关于页面请求处理
     * 
     * @return 关于页面视图名称
     */
    @GetMapping("/about")
    public String about() {
        return "about";
    }
    
    /**
     * 产品页面请求处理
     * 
     * @return 产品页面视图名称
     */
    @GetMapping("/products")
    public String products() {
        return "products";
    }
    
    /**
     * 服务页面请求处理
     * 
     * @return 服务页面视图名称
     */
    @GetMapping("/services")
    public String services() {
        return "services";
    }
    
    /**
     * 联系页面请求处理
     * 
     * @return 联系页面视图名称
     */
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}