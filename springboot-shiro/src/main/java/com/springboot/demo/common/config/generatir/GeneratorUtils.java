package com.springboot.demo.common.config.generatir;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码生成器工具类（测试）
 * <p>
 * 3.x生成的代码中，不含@TableField("name")
 * 官方人员的说法是：
 *
 * @author Wenyi Feng @miemie 【成员】
 * 根据规则生成的entity不再会出现多余的注解
 * @since 2018-08-31
 */
public class GeneratorUtils {

    /**
     * 执行生成代码
     */
    public static void generateCode() {
        String packageName = "com.springboot.demo";
        String moduleName = "sys";
        //generateByTables(packageName, "t_student", "t_city", "t_idcard");
        generateByTables(packageName, moduleName, "sys_user_role", "sys_role", "sys_menu", "sys_role_menu");
    }

    private static void generateByTables(String packageName, String moduleName, String... tableNames) {

        // 数据库信息
        String dbUrl = "jdbc:mysql://119.23.236.26:3306/shiro_demo?useUnicode=true&useSSL=false&characterEncoding=utf8";
        DataSourceConfig dataSourceConfig = new DataSourceConfig()
                .setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("honey")
                .setPassword("Honey521.")
                .setDriverName("com.mysql.cj.jdbc.Driver") // mysql 8
                /*.setTypeConvert(new MySqlTypeConvert() {
                    @Override
                    public PropertyInfo processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                        //.....
                        // 当发现生成的类型并不能满足你的要求时，可以去这里看，然后重写
                    }
                })*/;

        // 配置
        String projectPath = System.getProperty("user.dir");
        GlobalConfig config = new GlobalConfig()
                .setAuthor("hjy")
                .setOutputDir(projectPath + "/src/main/java")
                .setFileOverride(true)
                .setActiveRecord(true)// 不需要ActiveRecord特性的请改为false
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(true)// XML ResultMap
//                .setBaseColumnList(false)// XML columList
                .setKotlin(false) //是否生成 kotlin 代码
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
//                .setMapperName("%sDao")
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController")
                .setDateType(DateType.ONLY_DATE) //只使用 java.util.date 代替
                .setIdType(IdType.ID_WORKER)
                .setSwagger2(true) // model swagger2
                .setOpen(false) // 是否打开输出目录
                ;


        StrategyConfig strategyConfig = new StrategyConfig()
                .setCapitalMode(false) // 全局大写命名 ORACLE 注意
                //.setDbColumnUnderline(true)
//                .setTablePrefix("t_")// 此处可以修改为您的表前缀(数组)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setNaming(NamingStrategy.underline_to_camel) // 表名生成策略
                .setInclude(tableNames)//修改替换成你需要的表名，多个表名传数组
                //.setExclude(new String[]{"test"}) // 排除生成的表
                .setEntityLombokModel(true) // lombok实体
                .setEntityBuilderModel(false) // 【实体】是否为构建者模型（默认 false）
                .setEntityColumnConstant(false) // 【实体】是否生成字段常量（默认 false）// 可通过常量名获取数据库字段名 // 3.x支持lambda表达式
                .setRestControllerStyle(true)
//                .setSuperControllerClass("com.springboot.demo.system.controller") //父类controller
//                .setSuperEntityClass("com.springboot.demo.system.domain")   //
                //.setLogicDeleteFieldName("is_delete") // 逻辑删除属性名称
                //.setEntityTableFieldAnnotationEnable
                ;

        // 包信息配置
        PackageConfig packageConfig = new PackageConfig()
                .setParent(packageName)
                .setModuleName(moduleName)
                .setController("controller")
                .setEntity("entity")
                .setMapper("mapper")
                .setXml("mapper");

        // 执行器
        new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .execute();
    }

}
