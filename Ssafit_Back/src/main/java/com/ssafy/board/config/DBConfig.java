package com.ssafy.board.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.board.model.dao")
// 이 위의 것을 메인에다가 붙여도 상관은 없다만 메인에다가 붙이는 건 좀 별로...
public class DBConfig {

}
