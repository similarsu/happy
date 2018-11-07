# lombok学习笔记

## 安装
### gradle

#### 2.12 or up

**build.gradle**

```
plugins {
	id 'net.ltgt.apt' version '0.10'
}

dependencies {
	compileOnly 'org.projectlombok:lombok:1.18.4'

	apt 'org.projectlombok:lombok:1.18.4'
}
```

### idea

```
1、安装插件
2、在Settings设置页面，我们点击Build，Execution，Deployment-->选择Compiler-->选中Annotation Processors，然后在右侧勾选Enable annotation processing即可
3、点击View-->Tool Windows-->Structure，便可以看到类中所有的方法了，这些都是lombok帮我自动生成的
```

## 使用

### val

**注意**

```
仅能使用在本地变量和循环语句中
须赋值（用于推断数据类型）
不能使用在属性
```

**source**

```
val example = new ArrayList<String>();
```

**compile**

```
final ArrayList<String> example = new ArrayList<String>();
```

### var

```
与val相似，仅不带final
```

## log

### @SLF4J

**build.gradle**

```
compile group: 'ch.qos.logback', name: 'logback-classic', version: '1.2.3'
```

**注意**

```
可通过参数topic修改名称，默认为class type
如果log字段已经存在, 代码不会自动生成。
```

**source**

```
@Slf4j
public class SLF4JExample {
}
```

**compile**

```
private static final Logger log = LoggerFactory.getLogger(SLF4JExample.class);
```

## delombok

```
将含有lomok相关的代码，转换为正常的代码
```
**使用**

```
plugins {
    id 'java'
    id 'net.ltgt.apt' version '0.10'
    id 'io.franzbecker.gradle-lombok' version '1.14'
}

import io.franzbecker.gradle.lombok.task.DelombokTask

task delombok(type: DelombokTask, dependsOn: compileJava) {
    group = 'lombok'
    ext.outputDir = file("$buildDir/delombok")
    outputs.dir(outputDir)
    sourceSets.main.java.srcDirs.each {
        inputs.dir(it)
        args(it, "-d", outputDir)
    }
    doFirst {
        outputDir.deleteDir()
    }
}

task delombokHelp(type: DelombokTask) {
    group = 'lombok'
    args "--help"
}

javadoc {
    dependsOn delombok
    source = delombok.outputDir
    failOnError = false
    options{
        docEncoding 'utf-8'
        charSet 'utf-8'
    }
}
```

