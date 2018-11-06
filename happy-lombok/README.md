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