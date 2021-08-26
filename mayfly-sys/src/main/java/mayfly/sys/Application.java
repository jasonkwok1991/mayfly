package mayfly.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hml
 * @date 2018/6/7 下午5:21
 */
@SpringBootApplication
@MapperScan(basePackages = "mayfly.**.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
