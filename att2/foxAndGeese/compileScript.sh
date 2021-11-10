#!/bin/bash


javac —module-path "%javafxHome%"

—upgrade-module-path "%logPath%"

—add-modules ALL-MODULE-PATH
-d bin %mainPath%\*.java
-d bin %mainPath%\gameworld\cell\*.java
-d bin %mainPath%\gameworld\gamefield\*.java
-d bin %mainPath%\graph\*.java
-d bin %mainPath%\view\*.java
-d bin %mainPath%\game\*.java
