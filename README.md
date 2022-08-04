# README
- 项目名称：Mine Sweeper
- 项目作者：[FishHave](https://space.bilibili.com/426949000)
- 项目描述：一款自制的扫雷游戏。
- 项目语言：Java 18
- 协议：Apache

## 1. 运行
本项目启动类为[Application.java](src/main/java/net/sevensuns/minesweeper/Application.java)，Maven构建后直接
运行即可

## 2.依赖项
本项目需要__com.formdev__的__flatlaf__库依赖，该依赖用于本项目的窗体美化

## 3.环境
本项目需要JDK 18

## 4.目录

│  LICENSE.txt //协议
│  mine-sweeper.iml
│  pom.xml //Maven配置
│  README.md //help
│
├─.idea //idea生成文件夹
│  │  .gitignore
│  │  checkstyle-idea.xml
│  │  compiler.xml
│  │  encodings.xml
│  │  jarRepositories.xml
│  │  misc.xml
│  │  runConfigurations.xml
│  │  uiDesigner.xml
│  │  workspace.xml
│  │
│  ├─artifacts
│  │      Mine_Clearance_jar.xml
│  │
│  └─codeStyles
│          codeStyleConfig.xml
│          Project.xml
│
├─out //输出文件夹
│  └─artifacts
│      │  Mine_Clearance_jar.rar
│      │  Mine_Clearance_jar.zip
│      │  Mine_Clearance_jar2.zip
│      │
│      └─Mine_Clearance_jar
│              Mine_Clearance.jar.jar
│              请先读我.txt
│
├─src //源码文件夹
│  ├─main
│  │  ├─java //代码
│  │  │  └─net
│  │  │      └─sevensuns
│  │  │          └─minesweeper // 项目源码
│  │  │              │  Application.java //启动类
│  │  │              │
│  │  │              ├─config
│  │  │              │      Args.java //存放项目的参数
│  │  │              │
│  │  │              ├─mine
│  │  │              │      InvaildMineButtonException.java //异常
│  │  │              │      Location.java //位置对象
│  │  │              │      MineButton.java // 按钮对象
│  │  │              │
│  │  │              ├─module
│  │  │              │  └─role
│  │  │              │          RoleController.java //控制器
│  │  │              │
│  │  │              ├─util
│  │  │              │      CommandParser.java //指令解析器
│  │  │              │      ThemeManager.java //主题管理器
│  │  │              │      WinnerManager.java //裁判
│  │  │              │
│  │  │              └─windows
│  │  │                      MainWindow.java //主窗体
│  │  │
│  │  └─resources //资源文件
│  │      └─META-INF //信息
│  │              MANIFEST.MF
│  │
│  └─test //测试
│      └─java
└─target
    │  mine-sweeper-1.0.jar
    │
    ├─classes
    │  ├─com
    │  │  └─sevensuns
    │  │      │  Application.class
    │  │      │
    │  │      ├─config
    │  │      │      Args.class
    │  │      │
    │  │      ├─mine
    │  │      │      InvaildMineButtonException.class
    │  │      │      Location.class
    │  │      │      MineButton.class
    │  │      │
    │  │      ├─module
    │  │      │  └─role
    │  │      │          RoleController.class
    │  │      │
    │  │      ├─util
    │  │      │      CommandParser.class
    │  │      │      WinnerManager.class
    │  │      │
    │  │      └─windows
    │  │              MainWindow$1.class
    │  │              MainWindow.class
    │  │
    │  ├─META-INF
    │  │      MANIFEST.MF
    │  │
    │  └─net
    │      └─sevensuns
    │          └─minesweeper
    │              │  Application.class
    │              │
    │              ├─config
    │              │      Args.class
    │              │
    │              ├─mine
    │              │      InvaildMineButtonException.class
    │              │      Location.class
    │              │      MineButton.class
    │              │
    │              ├─module
    │              │  └─role
    │              │          RoleController.class
    │              │
    │              ├─util
    │              │      CommandParser.class
    │              │      ThemeManager.class
    │              │      WinnerManager.class
    │              │
    │              └─windows
    │                      MainWindow$1.class
    │                      MainWindow.class
    │
    ├─generated-sources
    │  └─annotations
    ├─maven-archiver
    │      pom.properties
    │
    └─maven-status
        └─maven-compiler-plugin
            ├─compile
            │  └─default-compile
            │          createdFiles.lst
            │          inputFiles.lst
            │
            └─testCompile
                └─default-testCompile
                        inputFiles.lst

