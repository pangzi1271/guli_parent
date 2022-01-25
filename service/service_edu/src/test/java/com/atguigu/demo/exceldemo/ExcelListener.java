package com.atguigu.demo.exceldemo;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @Description
 * @Author 老胖
 * @Date 22/01/2022 11:23 am
 */
public class ExcelListener extends AnalysisEventListener<DemoData> {


    // 逐行读取excel文件中的内容
    @Override
    public void invoke(DemoData data, AnalysisContext context) {
        System.out.println("----" + data);
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("cloumn head" + headMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
