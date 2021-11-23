@echo off

set CD=%~dp0
SET mainPath=ru\vsu\vadim\foxAndGeeese
SET binPath=%CD%bin

cd %binPath%
jar cvfe ../FoxGeese.jar ru.vsu.vadim.foxAndGeeese.Main  %mainPath%\graph\*.class %mainPath%\piece\*.class  %mainPath%\gameworld\*.class %mainPath%\game\*.class  %mainPath%\view\*.class %mainPath%\*.class