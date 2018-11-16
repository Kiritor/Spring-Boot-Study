/**
 * Copyright (C), 2014-2018, xx有限公司
 * FileName: GeneratorApp
 */
package com.kiritor;

import org.mybatis.generator.api.ShellRunner;

/**
 * 〈生成代码〉
 *
 * @author lcore
 * @create 18/11/15
 * @since 1.0.0
 */

public class GeneratorApp {

    public static void main( String[] args )
    {
        args = new String[] { "-configfile", "/Users/lcore/dev/code/Java/Spring-Boot-Study/springboot-mybatis-common/src/main/resources/mybatis/mybatis-generator.xml", "-overwrite" };
        ShellRunner.main(args);
    }
}
