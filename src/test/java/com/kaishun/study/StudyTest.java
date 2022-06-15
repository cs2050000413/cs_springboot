package com.kaishun.study;

import com.kaishun.study.test.AsyncTest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Package: com.kaishun.study
 * @ClassName: Test
 * @Author: zhoukaishun
 * @CreateTime: 2022/5/31 18:02
 * @Description:
 */
@SpringBootTest
public class StudyTest {

    @Resource
    private AsyncTest asyncTest;

    @Test
    public void test() throws Exception {
        asyncTest.test();
        asyncTest.test2();
    }

    @Test
    public void test2(){
        // map 中的key如果是对象，需要重写equals和hashcode方法
        Map<KeyItem,String> map = new HashMap<>();
        KeyItem item = new KeyItem(1);
        KeyItem item2 = new KeyItem(1);
        map.put(item,"第一个");
        map.put(item2,"第二个");
        System.out.println(map);
    }

    public class KeyItem{
        private Integer key;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            KeyItem item = (KeyItem) o;
            return Objects.equals(key, item.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        public Integer getKey() {
            return key;
        }

        public KeyItem(Integer key) {
            this.key = key;
        }
    }




}
