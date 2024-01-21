package com.wzy.guava.collections;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 集合工具类Main方法
 *
 * @author wzy
 * @date 2024-01-20 10:46:49
 */
public class CollectionsMain {
    public static void main(String[] args) {
        // 1、创建一个ArrayList
        List<String> nameList = Lists.newArrayList("zhangsan", "lisi", "wangwu");
        // 2、翻转list
        List<String> reverseNameList = Lists.reverse(nameList);

        System.out.println("reverseNameList:" + reverseNameList);
        // 3、创建一个HashSet
        HashSet<Integer> noSet1 = Sets.newHashSet(1, 2, 3, 3, 4);
        HashSet<Integer> noSet2 = Sets.newHashSet(3, 4, 8, 9, 1);
        // 4、set取并集，交集
        Set<Integer> noUnionSet = Sets.union(noSet1, noSet2);
        Set<Integer> noIntersectionSet = Sets.intersection(noSet1, noSet2);

        System.out.println("noUnionSet: " + noUnionSet);
        System.out.println("noIntersectionSet: " + noIntersectionSet);

        // 5、字符串判空
        String str = "";
        if (!Strings.isNullOrEmpty(str)) {
            // DO
        }

        // 6、连接多个字符串
        String joinStr = Joiner.on(",").join(nameList);
        System.out.println(joinStr);

    }
}
