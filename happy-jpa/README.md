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

## Limiting Query Results

**使用**

```
Top or First
```

**demo**

```
User findFirstByOrderByLastnameAsc();

User findTopByOrderByAgeDesc();

Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);

Slice<User> findTop3ByLastname(String lastname, Pageable pageable);

List<User> findFirst10ByLastname(String lastname, Sort sort);

List<User> findTop10ByLastname(String lastname, Pageable pageable);
```

**注**

```
The limiting expressions also support the Distinct keyword.
Also, for the queries limiting the result set to one instance, wrapping the result into with the Optional keyword is supported.
If pagination or slicing is applied to a limiting query pagination (and the calculation of the number of pages available), it is applied within the limited result.
```

## Query by Example

**使用**

```
public interface StudentRepository extends QueryByExampleExecutor<Student>{

}
```

**简单使用**

```
Student student = new Student();
student.setName(nameList.get(toRandom(nameList.size())));
student.setCountry(countryList.get(toRandom(countryList.size())));
Example<Student> example = Example.of(student);
```

**复杂使用**

### matching

```
matching: and
matchingAll: and
matchingAny: or
```

### withMatcher

```
单个配置
```
