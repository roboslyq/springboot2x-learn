package com.roboslyq.thymeleaf.springthymeleaf;

        import org.apache.tomcat.util.http.fileupload.IOUtils;
        import org.springframework.core.io.DefaultResourceLoader;
        import org.springframework.core.io.Resource;
        import org.springframework.core.io.ResourceLoader;
        import org.thymeleaf.context.Context;
        import org.thymeleaf.spring5.SpringTemplateEngine;

        import java.io.ByteArrayOutputStream;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.IOException;
        import java.io.InputStream;


public class SpringThymeleaf {
    public static void main(String[] args) throws IOException {
        // 构建引擎
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        // 创建渲染上下文
        Context context = new Context();
        //Spring资源加载器(主要功能是定位寻址)
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:/templates/hello-world.jsp");
        //获取原始文件流
        File file = resource.getFile();
        InputStream inputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //通过工具将输入流转成输出流
        IOUtils.copy(inputStream, outputStream);
        outputStream.close();
        inputStream.close();
        context.setVariable("message", "Hello,World");
        // 模板的内容（输出流很容易转成字符串）
        String content = outputStream.toString("UTF-8");
        // 渲染（处理）结果
        String result = templateEngine.process(content, context);
        // 输出渲染（处理）结果
        System.out.println(result);
    }
}
