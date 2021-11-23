@echo off

set CD=%~dp0
SET javafxHome=%CD%lib\openjfx-17.0.1_windows-x64_bin-sdk\javafx-sdk-17.0.1\lib
SET mainPath=%CD%src\ru\vsu\vadim\foxAndGeeese
set logPath=%CD%lib\lib


java --module-path "%javafxHome%" --upgrade-module-path "%logPath%" --add-modules ALL-MODULE-PATH -jar %CD%FoxGeese.jar