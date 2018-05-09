# export BOOT_JVM_OPTIONS="-Dclojure.compiler.direct-linking=true"

all: libproject.so project main

clean:
	rm -f main graal_isolate.h graal_isolate_dynamic.h libproject.h libproject.so libproject_dynamic.h main.o project
	rm -fr target

libproject.so libproject.h: target/libproject.jar
	native-image -H:Kind=SHARED_LIBRARY -H:Name=libproject -jar $<

#  --no-server -H:Dump=

project: target/libproject.jar
	native-image -jar $<
	mv libproject project

target/libproject.jar: src/**/*
	boot aot --all javac uber jar --main test.core -f libproject.jar target

main.o: main.c libproject.h
	gcc -fPIC -c -I. $<

main: main.o libproject.so
	gcc -fPIC -L. $< -lproject  -o $@

.PHONY: add
add: main
	export LD_LIBRARY_PATH=.:$LD_LIBRARY_PATH
	./main

.PHONY: decompile
decompile: target/libproject.jar
	java -jar ~/Downloads/procyon-decompiler-0.5.30.jar -jar target/libproject.jar -o out

.PHONY: run
run: main
	export LD_LIBRARY_PATH=.:$(LD_LIBRARY_PATH)
	./main
