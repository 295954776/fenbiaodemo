package com.example.demo.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    private static String author = "t";
    private static String url = "jdbc:mysql://localhost:3306/demo0?useUnicode=true&characterEncoding=UTF-8&useSSL=false&useAffectedRows=true&serverTimezone=GMT%2B8";

    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String userName = "root";
    private static String password = "123456";
    private static String part = "com.example.demo";
    private static String[] tables = {"admin0"};

    public static void main(String[] args) {
        // 1. 全局配置
        String projectPath = System.getProperty("user.dir");
        GlobalConfig gc = new GlobalConfig();
        // 生成文件的输出目录
        gc.setOutputDir(projectPath + "/src/main/java")
                // 是否覆盖已有文件
                .setFileOverride(true)
                // 是否打开输出目录
                .setOpen(false)
                // 是否在xml中添加二级缓存配置
                .setEnableCache(false)
                // 开发人员
                .setAuthor(author)
                // 开启 Kotlin 模式
                .setKotlin(false)
                // 开启 swagger2 模式
                .setSwagger2(false)
                // 开启 ActiveRecord 模式
                .setActiveRecord(false)
                // 开启 BaseResultMap
                .setBaseResultMap(true)
                // 开启 BaseColumnList
                .setBaseColumnList(true)
                // 时间类型对应策略
                .setDateType(DateType.TIME_PACK)
                // 默认值：null 例如：%sEntity 生成 UserEntity
                //.setEntityName(null)
                // 默认值：null 例如：%sDao 生成 UserDao
                //.setMapperName(null)
                // 默认值：null 例如：%sDao 生成 UserDao.xml
                //.setXmlName(null)
                // 设置生成的service接口的名字的首字母是否为I(默认Service类前面有一个I)
                .setServiceName("%sService")
                // 默认值：null 例如：%sBusinessImpl 生成 UserBusinessImpl
                //.setServiceImplName(null)
                // 默认值：null 例如：%sAction 生成 UserAction
                //.setControllerName(null)
                // 主键策略
                .setIdType(IdType.AUTO)
        ;

        // 2. 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        // 设置数据库类型
        dsc.setDbType(DbType.MYSQL)
                // 数据库 schema name 例如 PostgreSQL 可指定为 public
                //.setSchemaName("public")
                /*.setTypeConvert(new MySqlTypeConvert() {
                    // 自定义数据库表字段类型转换【可选】
                    @Override
                    public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                        logger.info("转换类型：" + fieldType);
                        if (fieldType.toLowerCase().contains(TINYINT)) {
                            return DbColumnType.BOOLEAN;
                        }
                        return super.processTypeConvert(globalConfig, fieldType);
                    }
                })*/
                .setUrl(url)
                .setDriverName(driverName)
                .setUsername(userName)
                .setPassword(password)
        ;

        // 3. 包名策略配置
        PackageConfig pc = new PackageConfig();
        // 设置父包名
        pc.setParent(part)
                // 设置父包模块名
                //.setModuleName(module)
                // Entity包名
                .setEntity("entity")
                // Service包名
                .setService("service")
                // Service Impl包名
                .setServiceImpl("service.impl")
                // Mapper包名
                .setMapper("mapper")
                // Mapper XML包名
                .setXml("mapper")
                // Controller 层
                .setController("controller")
        ;

        // 4. 策略配置
        // 自定义需要填充的字段
        //List<TableFill> tableFillList = new ArrayList<>();
        //tableFillList.add(new TableFill("SS", FieldFill.INSERT_UPDATE));
        StrategyConfig strategy = new StrategyConfig();
        // 数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel)
                // 数据库表字段映射到实体的命名策略
                .setColumnNaming(NamingStrategy.underline_to_camel)
                // 是否大写命名
                //.setCapitalMode(false)
                // 是否跳过视图
                //.setSkipView(false)
                // 设置表前缀
                //.setTablePrefix("smg" + "_")
                // 设置字段前缀
                //.setFieldPrefix()
                // 自定义实体父类
                //.setSuperEntityClass("com.gzfyit.shopping.base.BaseEntity")
                // 自定义实体，公共字段
                //.setSuperEntityColumns("createTime", "updateTime")
                // 自定义 mapper 父类 默认BaseMapper
                //.setSuperMapperClass("com.baomidou.mybatisplus.mapper.BaseMapper")
                // 自定义 service 父类 默认IService
                // .setSuperServiceClass("com.baomidou.demo.TestService")
                // 自定义 service 实现类父类 默认ServiceImpl
                // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
                // 自定义 controller 父类
                //.setSuperControllerClass("com.kichun."+packageName+".controller.AbstractController")
                // 需要生成的表
                .setInclude(tables)
                // 排除生成的表
                //.setExclude("")
                // 实体是否生成字段常量（默认 false）
                // public static final String ID = "test_id";
                //.setEntityColumnConstant(true)
                // 实体是否为构建者模型（默认 false）
                // public User setName(String name) {this.name = name; return this;}
                // .setEntityBuilderModel(true)
                // 实体是否为lombok模型（默认 false）
                .setEntityLombokModel(true)
                // Boolean类型字段是否移除is前缀处理
                //.setEntityBooleanColumnRemoveIsPrefix(true)
                // 是否生成实体时，生成字段注解
                //.entityTableFieldAnnotationEnable(false)
                // 设置乐观锁字段
                //.setVersionFieldName()
                // 设置逻辑删除字段
                //.setLogicDeleteFieldName()
                // 表填充字段
                //.setTableFillList(tableFillList)
                // RestController控制器
                .setRestControllerStyle(true)
                // 驼峰转连字符
                .setControllerMappingHyphenStyle(true)
        ;

        // 自定义配置
        InjectionConfig ic = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 自定义文件输出位置（非必须）
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        ic.setFileOutConfigList(focList);

        // 5. 整合配置
        // 代码生成器
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(gc)
                .setDataSource(dsc)
                .setPackageInfo(pc)
                .setStrategy(strategy)
                .setCfg(ic)
                // 关闭默认 xml 生成，调整生成 至 根目录
                .setTemplate(new TemplateConfig().setXml(null))
                // 自定义模板配置，模板可以参考源码/mybatis-plus/src/main/resources/template
                // 使用copy至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
                // .setController("...");
                // .setEntity("...");
                // .setMapper("...");
                // .setXml("...");
                // .setService("...");
                // .setServiceImpl("...");
                // 指定模板引擎 默认是VelocityTemplateEngine ，需要引入相关引擎依赖
                .setTemplateEngine(new FreemarkerTemplateEngine())
        ;

        // 6. 执行
        ag.execute();
    }
}
