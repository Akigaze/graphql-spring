```json
{
  "query": "query XYZ($id: ID!) { author(id: $id) { name }}",
  "variables": {
    "id": 1
  },
  "operationName": "XYZ"
}
```

### Client

#### 查询

- query之后可以自定义一个操作名, 如果没有操作名，query关键字可以省略
- 必须显示列出想要返回的字段

需要定义变量的查询，参数列表放在query之后，
```
query YouQueryName($id: ID!) {
  author(id: $id) {
    name
  }
}
```

组合多个查询
```
query WantAuthorAndGreeting {
  author(id: "2") {
    name
    books {
      bookName
    }
  }
  greeting
}
```
使用切片
```
{
  author(id: "2") {
    id
    ...authorBooks
  }
  greeting
}

fragment authorBooks on Author {
  name
  books {
    price
  }
}
```