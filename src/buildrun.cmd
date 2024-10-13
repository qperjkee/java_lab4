@echo off

javac %1.java
if errorlevel 1 goto ERROR

:RUN
java %1
goto END

:ERROR
echo "Build fails!"

:END