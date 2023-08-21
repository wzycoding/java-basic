package com.wzy.clone;

import java.io.*;

public class CopyTest {
    public static void main1(String[] args) throws CloneNotSupportedException {
        // 原对象
        Goods goods = new Goods();

        goods.setGoodsId(1);
        goods.setName("小米10S");
        MerchantInfo merchantInfo = new MerchantInfo();
        merchantInfo.setMerchantId(101);
        merchantInfo.setMerchantName("小米集团");
        goods.setMerchantInfo(merchantInfo);

        // 拷贝对象
        Goods copyGoods = goods.clone();
        // 修改
        copyGoods.setName("华为手机");
        copyGoods.getMerchantInfo().setMerchantName("华为");

        System.out.println(goods);
        System.out.println(copyGoods);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 原对象
        Goods goods = new Goods();

        goods.setGoodsId(1);
        goods.setName("小米10S");
        MerchantInfo merchantInfo = new MerchantInfo();
        merchantInfo.setMerchantId(101);
        merchantInfo.setMerchantName("小米集团");
        goods.setMerchantInfo(merchantInfo);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(goods);
        oos.flush();
        oos.close();
        bos.close();
        byte[] bytes = bos.toByteArray();
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);

        // 拷贝对象
        Goods copyGoods = (Goods) ois.readObject();
        // 修改
        copyGoods.setName("华为手机");
        copyGoods.getMerchantInfo().setMerchantName("华为");

        System.out.println(goods);
        System.out.println(copyGoods);
    }
}
