package com.atguigu.demo.exceldemo;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author 老胖
 * @Date 22/01/2022 10:52 am
 */
public class TestEasyExcel {
    public static void main(String[] args) {

        // 实现excel的写操作
        // 1. 设置excel保存的路径及文件名称
        // String fileName = "e:\\write.xlsx";

        // 2. 调用easyexcel里面的方法来实现写操作
        // EasyExcel.write(fileName, DemoData.class).sheet("学生列表").doWrite(getData());

        // 3. 调用easyexcel里面的方法来实现读操作
        String fileName = "e:\\write.xlsx";
        EasyExcel.read(fileName, DemoData.class, new ExcelListener()).sheet().doRead();
    }

    // 创建方法返回集合数据
    private static List<DemoData> getData() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setSno(i);
            data.setSname("Tom" + i);
            list.add(data);
        }

        return list;
    }
}
