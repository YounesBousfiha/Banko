#!bin/zsh

javac -cp "lib/postgresql.jar" -d out $(find . -name "*.java")

java -cp "out:lib/postgresql.jar" banque.Main
