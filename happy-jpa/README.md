# jpa 学习笔记

## Query Lookup Strategies

**使用**

```
@EnableJpaRepositories(queryLookupStrategy = QueryLookupStrategy.Key.XXX)
``` 

**说明**

```
默认是CREATE_IF_NOT_FOUND
可选
CREATE：to remove a given set of well known prefixes from the method name and parse the rest of the method
USE_DECLARED_QUERY：tries to find a declared query and throws an exception if cannot find one
CREATE_IF_NOT_FOUND:combines CREATE and USE_DECLARED_QUERY. It looks up a declared query first, and, if no declared query is found, it creates a custom method name-based query
```