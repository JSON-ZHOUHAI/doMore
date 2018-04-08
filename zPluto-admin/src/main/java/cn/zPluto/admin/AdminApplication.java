package cn.zPluto.admin;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ServletComponentScan
@MapperScan("cn.zPluto.admin.*.dao")
@SpringBootApplication
public class AdminApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(AdminApplication.class, args);
    }
}
