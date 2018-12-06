package chapter01

object HelloScala {

  /**
    * 1 Scala教程
    * 1.1 scala简介
    * scala是运行在 Java 虚拟机 (Java Virtual Machine)之上，轻松实现和丰富的 Java类库互联互通。它既支持面向对象的编程方式，又支持函数式编程。它写出的程序像动态语言一样简洁，但事实上它确是严格意义上的静态语言。
    *
    * 面向对象特性：Scala是一种纯面向对象的语言，每一个值都是对象。对象的数据类型以及行为由类和特征(Trait)描述。类抽象机制的扩展有两种途径。一种途径是子类继承，另一种途径是灵活的混入(Mixin)机制。这两种途径能避免多重继承的种种问题。
    *
    * 函数式编程：Scala也是一种函数式语言，其函数也能当成值来使用。Scala提供了轻量级的语法用以定义匿名函数，支持高阶函数，允许嵌套多层函数，并支持柯里化。Scala的Case Class及其内置的模式匹配相当于函数式编程语言中常用的代数类型(Algebraic Type)。
    *
    * 静态类型：Scala是具备类型系统，通过编译时的检查，保证代码的安全性和一致性。
    *
    * 良好并发机制：Scala把Erlang风格的基于actor的并发带进了JVM。开发者可以利用Scala的actor模型在JVM上设计具伸缩性的并发应用程序，它会自动获得多核心处理器带来的优势，而不必依照复杂的Java线程模型来编写程序。
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {
    println("hello scala")
  }
}
