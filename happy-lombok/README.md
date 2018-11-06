# how to use?
## gradle

### 2.12 or up

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