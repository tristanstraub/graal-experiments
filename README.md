Tested against labsjdk1.8.0_161-jvmci-0.42 java/javac

```sh
export JAVA_HOME=graalvm-1.0.0-rc1
export PATH=$JAVA_HOME/bin:$PATH
make clean all

./project

export LD_LIBRARY_PATH=.:$(LD_LIBRARY_PATH)
./main
```