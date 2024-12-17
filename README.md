# Quantum

On Ubuntu, remember to update to correct java version:

```shell
sudo alternatives --config java
sudo alternatives --config javac
```

Create presentation with make:

```shell
make
```

Hello-world:
```shell
src/main/java/helloworld.java
```

Import module example:
```shell
src/main/java/filechooserrun.java
```


```shell
export CLASSPATH=$(mvn -q exec:exec -Dexec.executable=echo -Dexec.args="%classpath")
src/main/java/pods.java
```