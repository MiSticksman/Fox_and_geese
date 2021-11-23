@echo off

set CD=%~dp0
SET javafxHome=%CD%lib\openjfx-17.0.1_windows-x64_bin-sdk\javafx-sdk-17.0.1\lib
SET mainPath=%CD%src\ru\vsu\vadim\foxAndGeeese
set logPath=%CD%lib\lib

javac --module-path "%javafxHome%" --upgrade-module-path "%logPath%" --add-modules ALL-MODULE-PATH -d bin %mainPath%\graph\*.java -d bin %mainPath%\piece\*.java -d bin %mainPath%\gameworld\*.java -d bin %mainPath%\game\*.java -d bin %mainPath%\view\*.java -d bin %mainPath%\*.java