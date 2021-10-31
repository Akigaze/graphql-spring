package demo.graphql.bootstarter.v1;

import graphql.schema.idl.RuntimeWiring;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Arrays;

// 自定义的手动配置器，默认会自动加载一个注解的配置器
@Component
public class CustomizeRuntimeWiring implements RuntimeWiringConfigurer {

    @Override
    public void configure(RuntimeWiring.Builder builder) {
        
        builder.type("Query", typeWiring -> {
            
            // 查询greeting,返回hello
            typeWiring.dataFetcher("greeting", env -> "hello");

            // 查询作者 
            typeWiring.dataFetcher("author", env -> {

                Integer id = Integer.valueOf(env.getArgument("id"));

                Author author = new Author();
                author.setId(id);
                author.setName("小明");
                author.setSex(SexEnum.man);

                Book book1 = new Book();
                book1.setBookName("无敌拳法十三式");
                book1.setPublish(false);
                book1.setPrice(new SecureRandom().nextFloat());

                Book book2 = new Book();
                book2.setBookName("独孤十三剑");
                book2.setPublish(true);
                book2.setPrice(new SecureRandom().nextFloat());

                author.setBooks(Arrays.asList(book1, book2));

                return author;
            });

            return typeWiring;
        });
    }
}
