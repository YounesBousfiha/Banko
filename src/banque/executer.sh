#!bin/zsh

javac -d out $(find . -name "*.java")

java -cp out banque.Main
