package com.wzy.concurrent.immutable;

/**
 * @author wzy
 * @version 1.0
 * @date 2022/6/30 3:55 下午
 */
public class Category {

    public String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                '}';
    }
}