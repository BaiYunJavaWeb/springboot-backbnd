package cn.byjavaweb.mshop.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.byjavaweb.mshop.mapper")
public class MybatisPlusConfig {
}
