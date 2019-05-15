package com.roboslyq.webflux;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.roboslyq.webflux.entity.User;
import com.roboslyq.webflux.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * <p>
 * 内置 CRUD 演示
 * </p>
 */
// 获取启动类，加载配置，确定装载 Spring 程序的装载方法，它回去寻找主配置启动类
// （被 @SpringBootApplication 注解的）
@SpringBootTest
// 让 JUnit 运行 Spring 的测试环境， 获得 Spring 环境的上下文的支持
@RunWith(SpringRunner.class)

public class MybatisplusTest {
    /**
     * 注入mybatis-plus userMapper
     */
    @Autowired
    private UserMapper userMapper;

    @Test
    public void userInsert() {
        User user = new User();
        user.setId(1L)
                .setEmail("robosloveu@163.com")
                .setName("roboslyq")
                .setAge(18)
                .setNickname("roboslyq")
                .setPassword("123456")
                .setSex("M");
        assertThat(userMapper.insert(user)).isGreaterThan(0);
        // 成功直接拿会写的 ID
        assertThat(user.getId()).isEqualTo(1);
    }
    @Test
    public void userDelete() {
        assertThat(userMapper.deleteById(1128687057652686849L)).isGreaterThan(0);
        assertThat(userMapper.delete(new QueryWrapper<User>()
                .lambda().eq(User::getName, "roboslyq"))).isGreaterThan(0);
    }
    @Test
    public void userUpdate() {
        assertThat(userMapper.updateById(new User().setId(1L).setEmail("roboslyq@qq.com"))).isGreaterThan(0);
        assertThat(
                userMapper.update(
                        new User().setName("roboslyq1"),
                        Wrappers.<User>lambdaUpdate()
                                .set(User::getAge, 19)
                                .eq(User::getId, 2)
                )
        ).isGreaterThan(0);
        User user = userMapper.selectById(2);
        assertThat(user.getAge()).isEqualTo(3);
        assertThat(user.getName()).isEqualTo("mp");

        userMapper.update(
                null,
                Wrappers.<User>lambdaUpdate().set(User::getEmail, null).eq(User::getId, 2)
        );
        assertThat(userMapper.selectById(1).getEmail()).isEqualTo("ab@c.c");
        user = userMapper.selectById(2);
        assertThat(user.getEmail()).isNull();
        assertThat(user.getName()).isEqualTo("mp");

        userMapper.update(
                new User().setEmail("miemie@baomidou.com"),
                new QueryWrapper<User>()
                        .lambda().eq(User::getId, 2)
        );
        user = userMapper.selectById(2);
        assertThat(user.getEmail()).isEqualTo("miemie@baomidou.com");

        userMapper.update(
                new User().setEmail("miemie2@baomidou.com"),
                Wrappers.<User>lambdaUpdate()
                        .set(User::getAge, null)
                        .eq(User::getId, 2)
        );
        user = userMapper.selectById(2);
        assertThat(user.getEmail()).isEqualTo("miemie2@baomidou.com");
        assertThat(user.getAge()).isNull();
    }
    @Test
    public void userSelect() {
        userMapper.insert(
                new User().setId(10086L)
                        .setName("miemie")
                        .setEmail("miemie@baomidou.com")
                        .setAge(3));
        assertThat(userMapper.selectById(10086L).getEmail()).isEqualTo("miemie@baomidou.com");
        User user = userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getId, 10086));
        assertThat(user.getName()).isEqualTo("miemie");
        assertThat(user.getAge()).isEqualTo(3);

        userMapper.selectList(Wrappers.<User>lambdaQuery().select(User::getId))
                .forEach(x -> {
                    assertThat(x.getId()).isNotNull();
                    assertThat(x.getEmail()).isNull();
                    assertThat(x.getName()).isNull();
                    assertThat(x.getAge()).isNull();
                });
        userMapper.selectList(new QueryWrapper<User>().select("id","name"))
                .forEach(x -> {
                    assertThat(x.getId()).isNotNull();
                    assertThat(x.getEmail()).isNull();
                    assertThat(x.getName()).isNotNull();
                    assertThat(x.getAge()).isNull();
                });
    }

    @Test
    public void orderBy() {
        List<User> users = userMapper.selectList(Wrappers.<User>query().orderByAsc("age"));
        assertThat(users).isNotEmpty();
    }

    @Test
    public void selectMaps() {
        List<Map<String, Object>> mapList = userMapper.selectMaps(Wrappers.<User>query().orderByAsc("age"));
        assertThat(mapList).isNotEmpty();
        assertThat(mapList.get(0)).isNotEmpty();
        System.out.println(mapList.get(0));
    }

    @Test
    public void selectMapsPage() {
        IPage<Map<String, Object>> page = userMapper.selectMapsPage(new Page<>(1, 5), Wrappers.<User>query().orderByAsc("age"));
        assertThat(page).isNotNull();
        assertThat(page.getRecords()).isNotEmpty();
        assertThat(page.getRecords().get(0)).isNotEmpty();
        System.out.println(page.getRecords().get(0));
    }

    @Test
    public void orderByLambda() {
        List<User> users = userMapper.selectList(Wrappers.<User>lambdaQuery().orderByAsc(User::getAge));
        assertThat(users).isNotEmpty();
    }

    @Test
    public void testSelectMaxId() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("max(id) as id");
        User user = userMapper.selectOne(wrapper);
        System.out.println("maxId=" + user.getId());
        List<User> users = userMapper.selectList(Wrappers.<User>lambdaQuery().orderByDesc(User::getId));
        Assert.assertEquals(user.getId().longValue(), users.get(0).getId().longValue());
    }
}