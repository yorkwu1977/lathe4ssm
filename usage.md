使用方法
-------------------------------------------------------------------------------

1. 新建基于ssm框架的maven项目

lathe4ssm项目本身就是一个基于ssm框架的maven项目，可以复制本项目结构来创建新的项目

-------------------------------------------------------------------------------

2. 生成dao和model

在文件系统打开src/test/resources目录，修改相应配置文件后，执行generator.bat

需要根据实际情况修改的配置文件：
src\main\resources\spring-config.xml
src\main\resources\application_***.properties

-------------------------------------------------------------------------------

3. 生成service, controller, view

发布lathe4ssm项目到tomcat(或其它web服务器), 进入首页，点击左侧菜单【代码生成】-【SSM】
输入相关信息后，点击【提交】

需要根据实际情况修改的配置文件：
src\test\resources\generatorConfig.xml
src\test\resources\generatorConfig_***.properties
