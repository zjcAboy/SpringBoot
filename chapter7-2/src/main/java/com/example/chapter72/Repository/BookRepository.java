package com.example.chapter72.Repository;

import com.example.chapter72.Bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "bs",collectionResourceRel = "bs",itemResourceRel = "b")
//path 属性表示 请求路径
//collectionResourceRel 属性表示 返回的JSON集合中的Book集合的Key改为bs
//itemResourceRel 属性表示 返回的JSON集合中的单个book的key改为b
public interface BookRepository extends JpaRepository<Book,Integer> {
    //自定义查询方法
    @RestResource(path = "author",rel = "author")//4
    List<Book> findByAuthorContains(@Param("author") String author1);//5
    @RestResource(path = "name",rel = "name")//6
    Book findByNameEquals(@Param("name") String name1);//7
}
/*
自定义查询只需要在 BookRepository 中定义相关查询方法即可，方法定义好之后可以不添加
@RestResource 解，默认路径就是方法名 。以第4行定义的方法为例，若不添加
@RestResource 注解，则默认该方法的调用路径为
http://localhost:8080/bs/search/findByAuthorContains?author=鲁迅
如果想对查询路径进行自定义，只需要添加＠RestResource 注解即可， path属性即表示最新的路径。还是以第4行的方
法为例，添加＠RestResource(path =”author" ,rel ＝”author”）注解后的查询路径为
http://localhost:8080/bs/search/author?author=鲁迅”
用户可以直接访问 http://localhost:8080/bs/search 路径查看该实体类暴露出来了哪些查询方法，
默认情况 在查询方法展示时使用的路径是方法名，通过＠RestResource 注解中的 path 属性
可以对这里的路径进行重定义
"href": "http://localhost:8080/bs/search/author{?author}",重新定义author(第一个author)
 */