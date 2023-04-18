package org.example.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.RequiredArgsConstructor;
import org.example.beans.BeanI;
import org.example.beans.SomeClass;
import org.example.convertor.ToAConverter;
import org.example.convertor.ToBigDecimalConditionConverter;
import org.example.convertor.ToBigDecimalConverter;
import org.example.convertor.ToHexConverter;
import org.example.dto.Human;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.annotation.*;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@RequiredArgsConstructor
@EnableAspectJAutoProxy
@EnableJpaRepositories("org.example.repo")
@ComponentScan({"org.example"})
public class SpringConfig {
//    @Bean(value = "someClass")
//    public BeanI someClassWithName1() {
//        return new SomeClass("Name1");
//    }
//    @Bean(name = "myClass")
//    public BeanI someClassWithName2() {
//        return new MyClass();
//    }

    private final ToBigDecimalConverter toBigDecimalConverter;
    private final ToBigDecimalConditionConverter toBigDecimalConditionConverter;
    private final ToHexConverter toHexConverter;
    private final ToAConverter toAConverter;
    private final Human human;
    @Bean
    public BeanI someClass() {
        return new SomeClass("Ilya");
    }


    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper(new YAMLFactory());
    }
//    @Bean
//    public Human human() {
//        return new Human();
//    }

    @Bean
    public BeanWrapper beanWrapper() {
        return new BeanWrapperImpl(human);
    }

    @Bean
    public DefaultConversionService defaultConversionService() {
        DefaultConversionService defaultConversionService = new DefaultConversionService();
        defaultConversionService.addConverter(toHexConverter);
        defaultConversionService.addConverter(toAConverter);
       // defaultConversionService.addConverter(toBigDecimalConverter);
        defaultConversionService.addConverter(toBigDecimalConditionConverter);
        return defaultConversionService;
    }

//    @Bean
//    public BeanI myClass() {
//        return new MyClass();
//    }



//
//    @Bean
//    public DataSource getMySQLDataSource() {
//        Properties props = new Properties();
//        FileInputStream fis = null;
//        MysqlDataSource mysqlDS = null;
//        try {
//            fis = new FileInputStream("db.properties");
//            props.load(fis);
//            mysqlDS = new MysqlDataSource();
//            mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
//            mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
//            mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return mysqlDS;
//    }

//    @Bean
//    public PlayerDao playerDao() {
//        return new PlayerDao("SomeName", "");
//    }

//    @Bean
//    public PlayerService playerService() {
//        return new PlayerServiceImpl(playerDao());
//    }
}
