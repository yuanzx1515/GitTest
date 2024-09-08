package org.easybuy.Util;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import java.io.Writer;
public class ThymeleafUtil {

    private static final TemplateEngine engine;

    static {
        engine = new TemplateEngine();
        ClassLoaderTemplateResolver r = new ClassLoaderTemplateResolver();
        engine.setTemplateResolver(r);
        r.setCharacterEncoding("UTF-8");
    }

    // 保留原有的 process 方法
    public static void process(String template, IContext context, Writer writer) {
        engine.process(template, context, writer);
    }
}
