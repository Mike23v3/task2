/**
 * 轮播图功能实现
 * 实现首页轮播图的自动播放、手动控制和文字内容与图片的同步移动效果
 * 
 * 核心功能：
 * - 背景图片平滑切换动画
 * - 文字内容与图片同步移动效果
 * - 自动播放与手动控制（左右箭头、指示器）
 * - 鼠标悬停时暂停自动播放，离开时恢复
 * - 响应式适配不同屏幕尺寸
 */

// 等待DOM加载完成
document.addEventListener('DOMContentLoaded', function() {
    // 获取轮播图相关DOM元素
    const carousel = document.getElementById('mainCarousel');
    const carouselItems = carousel.querySelectorAll('.carousel-item');
    const prevBtn = document.getElementById('prevBtn');
    const nextBtn = document.getElementById('nextBtn');
    const indicators = document.querySelectorAll('.carousel-indicators button');
    
    // 轮播图配置参数
    let currentIndex = 0;           // 当前显示的幻灯片索引
    const totalItems = carouselItems.length; // 幻灯片总数
    const autoPlayInterval = 5000;  // 自动播放间隔，单位毫秒
    let slideInterval;              // 自动播放定时器ID
    
    // 初始化轮播图
    function initCarousel() {
        // 确保第一个项目处于激活状态
        if (carouselItems.length > 0) {
            carouselItems[0].classList.add('active');
            indicators[0].classList.add('active');
        }
        
        // 开始自动播放
        startAutoPlay();
        
        // 添加事件监听器
        addEventListeners();
    }
    
    // 开始自动播放
    function startAutoPlay() {
        slideInterval = setInterval(() => {
            nextSlide();
        }, autoPlayInterval);
    }
    
    // 停止自动播放
    function stopAutoPlay() {
        clearInterval(slideInterval);
    }
    
    /**
     * 切换到下一张幻灯片
     * 使用取模运算实现循环播放效果
     */
    function nextSlide() {
        // 计算下一张幻灯片的索引，使用取模运算实现循环
        const nextIndex = (currentIndex + 1) % totalItems;
        // 向右方向切换幻灯片
        changeSlide(currentIndex, nextIndex, 'right');
        // 更新当前索引
        currentIndex = nextIndex;
    }
    
    /**
     * 切换到上一张幻灯片
     * 使用+totalItems确保索引始终为非负数
     */
    function prevSlide() {
        // 计算上一张幻灯片的索引，+totalItems确保结果非负
        const prevIndex = (currentIndex - 1 + totalItems) % totalItems;
        // 向左方向切换幻灯片
        changeSlide(currentIndex, prevIndex, 'left');
        // 更新当前索引
        currentIndex = prevIndex;
    }
    
    /**
     * 切换幻灯片的核心函数 - 实现平滑过渡效果
     * 该函数处理幻灯片之间的切换动画，包括图片和文字的同步移动
     * 
     * @param {number} fromIndex - 当前幻灯片索引
     * @param {number} toIndex - 目标幻灯片索引
     * @param {string} direction - 切换方向 ('left' 或 'right')
     */
    function changeSlide(fromIndex, toIndex, direction) {
        // 移除当前活动幻灯片的active类，使其淡出
        carouselItems[fromIndex].classList.remove('active');
        indicators[fromIndex].classList.remove('active');
        
        // 获取目标幻灯片元素
        const nextItem = carouselItems[toIndex];
        
        // 根据切换方向添加相应的进入动画类
        // slide-in-left: 从左侧滑入
        // slide-in-right: 从右侧滑入
        nextItem.classList.add(direction === 'left' ? 'slide-in-left' : 'slide-in-right');
        
        // 使用requestAnimationFrame确保在下一个渲染帧执行，保证动画流畅
        requestAnimationFrame(() => {
            // 添加active类，激活目标幻灯片的显示
            nextItem.classList.add('active');
            indicators[toIndex].classList.add('active');
            
            // 动画完成后（500ms）移除临时动画类，为下次切换做准备
            setTimeout(() => {
                nextItem.classList.remove('slide-in-left', 'slide-in-right');
            }, 500);
        });
        
        // 更新指示器状态 - 注意：由于前面已经手动设置了active类，这里可以省略
        // 如果需要更统一的状态管理，可以只调用updateIndicators而不手动设置active类
    }
    
    // 更新指示器状态
    function updateIndicators(activeIndex) {
        indicators.forEach((indicator, index) => {
            if (index === activeIndex) {
                indicator.classList.add('active');
            } else {
                indicator.classList.remove('active');
            }
        });
    }
    
    // 跳转到指定索引的幻灯片
    function goToSlide(index) {
        if (index === currentIndex) return;
        
        const direction = index > currentIndex ? 'right' : 'left';
        changeSlide(currentIndex, index, direction);
        currentIndex = index;
        
        // 重置自动播放计时器
        resetAutoPlay();
    }
    
    // 重置自动播放计时器
    function resetAutoPlay() {
        stopAutoPlay();
        startAutoPlay();
    }
    
    // 添加事件监听器
    function addEventListeners() {
        // 上一张按钮点击事件
        prevBtn.addEventListener('click', () => {
            prevSlide();
            resetAutoPlay();
        });
        
        // 下一张按钮点击事件
        nextBtn.addEventListener('click', () => {
            nextSlide();
            resetAutoPlay();
        });
        
        // 指示器点击事件
        indicators.forEach((indicator, index) => {
            indicator.addEventListener('click', () => {
                goToSlide(index);
            });
        });
        
        // 鼠标悬停在轮播图上时暂停自动播放
        carousel.addEventListener('mouseenter', stopAutoPlay);
        
        // 鼠标离开轮播图时恢复自动播放
        carousel.addEventListener('mouseleave', startAutoPlay);
        
        // 添加键盘导航支持
        document.addEventListener('keydown', (e) => {
            if (e.key === 'ArrowLeft') {
                prevSlide();
                resetAutoPlay();
            } else if (e.key === 'ArrowRight') {
                nextSlide();
                resetAutoPlay();
            }
        });
    }
    
    // 初始化轮播图
    initCarousel();
    
    // 响应式调整轮播图高度（可选）
    function adjustCarouselHeight() {
        const viewportWidth = window.innerWidth;
        const carouselContainer = document.querySelector('.carousel-container');
        
        if (viewportWidth < 576) {
            carouselContainer.style.height = '350px';
        } else if (viewportWidth < 768) {
            carouselContainer.style.height = '400px';
        } else if (viewportWidth < 992) {
            carouselContainer.style.height = '450px';
        } else if (viewportWidth < 1200) {
            carouselContainer.style.height = '500px';
        } else {
            carouselContainer.style.height = '600px';
        }
    }
    
    // 窗口调整大小时重新调整轮播图高度
    window.addEventListener('resize', adjustCarouselHeight);
    
    // 初始调整轮播图高度
    adjustCarouselHeight();
    
    // 为轮播图项添加进入和退出动画的辅助函数
    function animateCarouselItem(item, isEntering, direction) {
        // 重置项的初始状态
        item.style.opacity = '0';
        item.style.transform = direction === 'left' ? 'translateX(-100%)' : 'translateX(100%)';
        
        // 强制重绘
        item.offsetHeight;
        
        // 应用过渡样式
        item.style.transition = 'opacity 0.5s ease-in-out, transform 0.5s ease-in-out';
        
        // 设置目标状态
        if (isEntering) {
            item.style.opacity = '1';
            item.style.transform = 'translateX(0)';
        }
    }
});