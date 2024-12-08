name: inverse
layout: true
class: center, middle, inverse
---
# Java as shell script

.footnote[18.12.2024 Erlend Nossum]
???

Made with: https://github.com/gnab/remark

Inspired by https://www.redpill-linpro.com/techblog/2024/02/21/java-21-shell-scripts.html

---
layout: false
# Agenda

- Run java as shell script
- ... using modern java constructions

---
# When is this useful?

Shell scripts are used to perform and organize simple tasks. 

- Bash scripts quickly get **untenable**.
- You can get type safety and other **niceness** when using Java
- Example: Load **test data into database**
  - Instead of a disabled junit test that loads a database with example data, you
    can create a script which has better transparency, and also **easier to document**
- When you do not want or need a full-blown jar application
- Distribution and **documentation** is easy

---
# Hello world

This is the modern version of hello world in java:
```shell
cat > /tmp/hello <<EOF
void main() {
    System.out.println("Hello, World!");
}
EOF
```

Need preview flag to enable implicitly declared classes

You can run the code without a compilation step, like this:
```shell
java --source 23 --enable-preview /tmp/hello
```

We **want to run it directly**, without the "java" command prefix

---
# Hello world as a shell script

Add a shebang to make the java code into a **shell script**

```shell
cat > /tmp/hello <<EOF
///usr/bin/env java --source 23 --enable-preview "\$0" "\$@"; exit \$?
void main() {
    System.out.println("Hello, World!");
}
EOF
chmod a+x /tmp/hello
/tmp/hello
```

- More versatile
- Need to make file executable, of course
- The triple slash gets normalized upon execution
---
# If not yet on modern java version

What if you want to run this on legacy java version?
```shell
cat > /tmp/hello <<EOF
///usr/bin/env java --source 11 "\$0" "\$@"; exit \$?
public class HelloSnippet {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
EOF
chmod a+x /tmp/hello
/tmp/hello
```

---
# Why not jshell

- exit code is always 0
- if exceptions are thrown, code continues to be executed
- too lax with regards to errors

**Why not fat jar?**
- You do not want to distribute the jar
- You want transparency in regard to script content
- Skip the explicit build step
- Do not need a lot of functionality

---
# Module import for dependencies

- Using module import for simplicity
- This script could reside anywhere, but I put
  it in a source root to get it checked by compiler
```shell
./src/main/java/jshellrun.java
```
- Case in point:
```shell
cp ./src/main/java/jshellrun.java /tmp/jshellrun
/tmp/jshellrun
```
---
# What if you need packages

- This shows how you can depend on, and use packages as dependencies
- ... but you might want to consider going for a **fat jar** instead
- Note that with a single maven dependency, you typically get a lot of **transitive dependencies**

```shell
mvn -q exec:exec -Dexec.executable=echo -Dexec.args="%classpath"
```
You will use it like this:
```shell
CLASSPATH=$(mvn -q exec:exec -Dexec.executable=echo -Dexec.args="%classpath") \
  ./src/main/java/pods.java
```

---
layout: true
class: center, middle, inverse
---
# Questions?