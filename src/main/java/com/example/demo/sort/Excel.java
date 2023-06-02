package com.example.demo.sort;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.listener.ReadListener;
import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.util.*;
import java.util.stream.Collectors;

public class Excel {

    public static final String X = "01df59fa-79cb-4959-9fbe-3131d0773729\n" +
            "028f1500-99a7-4199-a7f0-c948124910a3\n" +
            "03af7360-d475-4930-b5c4-1edc3200f9a2\n" +
            "0c350c75-714a-446e-8454-154a906cff31\n" +
            "0f5a7f04-bcca-4165-bf8a-8b55bfbc84ea\n" +
            "18edc8e4-17c4-4ece-8a56-6c67b0d6ba30\n" +
            "21d884b4-3fa2-4821-83c5-6e961c064f4a\n" +
            "249b40b0-c344-4b98-ad13-f72f2c26eea0\n" +
            "2901c7a6-2064-4fdb-bc85-1de804e75d5e\n" +
            "2dea5e44-fb51-445a-bac1-d8a853269bc4\n" +
            "317a17a6-32e3-4cfa-8cc0-48480a20f77e\n" +
            "32511328-0e95-41fb-9b3e-65214284b116\n" +
            "329d13b7-7e40-459e-b136-4931df5e3d91\n" +
            "34b5ac97-8b46-4204-bf4f-895558f4f007\n" +
            "453b8948-0196-4023-9bf9-f44507216e9f\n" +
            "4644f45a-3a33-4e9e-828a-cc1f65469ac5\n" +
            "4a106c59-c36e-4b80-9cb3-404d4372025d\n" +
            "4d9ef2da-f019-4763-90d9-bf109feaf493\n" +
            "507d9279-f5b0-4246-afb7-cdd20390e441\n" +
            "52cd63c7-0221-4090-8ea6-3b744c99299e\n" +
            "5419b976-498a-4710-88ef-7c22ca4bda03\n" +
            "62280ed6-7b94-4467-b775-9a0209528f1d\n" +
            "62fe727b-5535-4f75-b68e-11036ffe061e\n" +
            "64a22b5f-e9f1-45f9-acc1-7c7a0264f4e1\n" +
            "65a623d6-a269-408e-8b74-3356ce6840b7\n" +
            "673d814d-38f3-418e-8677-340b9f0a40e7\n" +
            "683caf14-951c-4eb0-87cd-bd1d0a270ac7\n" +
            "76b26bd8-eb84-429d-ae68-45f7fb7c2859\n" +
            "77f5816f-5245-4afa-b24d-504fd62c3a01\n" +
            "7ac0a631-646a-4fae-a4cd-5891c9393cec\n" +
            "81213e9b-56c7-4e5e-8d1b-9ac353be94c2\n" +
            "81352b85-21e8-4242-a2aa-8deab3ae3580\n" +
            "81553af8-6f6b-4916-a2ab-abac3dbd4f54\n" +
            "81cba96c-c96e-4c24-b8cc-af48b52f4442\n" +
            "828268b6-f6ec-414d-b0a2-4fcf5795918d\n" +
            "8b3197be-b4da-491d-b2cc-9bac58b37b23\n" +
            "8dc6983c-2950-4875-a051-3d1a24b05b8d\n" +
            "95d42565-6b46-4bca-8734-f5e028a7cdab\n" +
            "a0d06211-08ee-43f9-a4c5-4c524e9490b8\n" +
            "a112984c-ff4e-47e6-a4e9-fd0c823150ad\n" +
            "a9300e93-ff78-42ba-a765-2f11cb057db6\n" +
            "a9d23765-7368-4cf3-91a4-b2aca27c167b\n" +
            "b0aaf0cf-f9c0-400a-b4ca-0fa0f3810403\n" +
            "b9ef0612-cf7a-444d-a693-60187276ec1e\n" +
            "c1cbad8a-c5af-4c03-a0ce-6d713c1a021c\n" +
            "c276702a-cbd5-4e97-aac9-56b01176cb81\n" +
            "c2d0c1c7-6bd4-4c76-96e1-52326375b982\n" +
            "c4e19425-71fd-4e4f-83d6-6840cbcfe17c\n" +
            "c67d504b-268d-4084-8cf7-164adc56bd4f\n" +
            "d0dec77a-60e9-476f-9afe-d3a013988826\n" +
            "d144bb87-9f3d-4cd6-b75d-6de017f9963b\n" +
            "d3cb3392-1d2e-4c19-9547-8b04483428df\n" +
            "d6caa09a-2a24-45f1-9c57-3f01ae6f1ea6\n" +
            "d8d46e7b-7128-4463-8958-449ff82a1447\n" +
            "dec34f1b-daf8-4b65-9de0-3dda1a8fe74c\n" +
            "e12540a5-2b71-488a-a8a7-b096f523be1d\n" +
            "e3dbbfb5-4f52-4206-8d52-0b9e85c6dfa0\n" +
            "e6313a2c-b8eb-4106-8b34-6c6872de0d03\n" +
            "e749b8da-084b-4890-9a4e-81039a758316\n" +
            "f0c8ec9a-88d1-4916-b5a6-70ac6e6c580a\n" +
            "f4c0ce0f-4fa7-4fdd-8072-7611de75b06a\n" +
            "fae733b6-6ee8-4b9e-8298-1bcf823b15ae";

    @Data
    public static class Table{
        private String first;
        private String second;
        private String three;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Table table = (Table) o;
            return Objects.equals(second, table.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(second);
        }
    }
    public static void main(String[] args) {
        String fileName = "E:\\123.xlsx";

        List<Table> tableList = new ArrayList<>();
        EasyExcel.read(fileName, Table.class, new ReadListener<Table>() {

            @Override
            public void invoke(Table table, AnalysisContext analysisContext) {
                tableList.add(table);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet().doRead();
        Set<Table> lists = tableList.stream().map(e -> {
            Table table = new Table();
            table.setFirst(e.getFirst());
            String second = e.getSecond();
            String s = second.substring(second.indexOf("deviceId="));
            s = s.substring(s.indexOf("=")+1, s.indexOf(","));
            table.setSecond(s);
            return table;
        }).collect(Collectors.toSet());

        String[] split = X.split("\n");
        Set<String> init = Arrays.stream(split).collect(Collectors.toSet());
        lists.forEach(e->{
            if(init.contains(e.getSecond())){
                e.setThree("通过");
            }else{
                e.setThree("未通过");
            }
        });
        EasyExcel.write("E:\\207343389.xlsx").sheet("207343389").doWrite(lists);

    }
}
