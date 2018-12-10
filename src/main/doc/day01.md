<!-- MarkdownTOC -->

<!-- /MarkdownTOC -->

## Null、null、 Nothing、 Nil、 None和Unit的区别
### Null和null
  
  **Null**  空(Null)是一个trait，它（如果你不熟悉trait）有点像Java中的抽象类。
确实存在一个空的实例，那是空的。

  **null** 字面null与Java中的相同。它是不引用任何对象的引用的值。
  
#### 因此，如果您编写一个采用Null类型参数的方法，则只能传递两个值：null本身或Null类型的引用。
```
scala> def tryit(thing: Null): Unit = { println("That worked!"); }
tryit: (Null)Unit

scala> tryit("hey")
<console>:6: error: type mismatch;
 found   : java.lang.String("hey")
 required: Null
       tryit("hey")
             ^

scala> val someRef: String = null
someRef: String = null

scala> tryit(someRef)
<console>:7: error: type mismatch;
 found   : String
 required: Null
       tryit(someRef)
             ^

scala> tryit(null)
That worked!

scala> val nullRef: Null = null
nullRef: Null = null

scala> tryit(nullRef)
That worked!

```
