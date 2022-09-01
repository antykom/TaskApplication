call runcrud.bat
if "%ERRORLEVEL%" == "0" goto edge
echo.
echo RUNCRUD has errors – breaking work
goto fail

:edge
start microsoft-edge:http://localhost:8080/crud/v1/task/tasks
if %ERRORLEVEL% ==  "0" goto end
echo.
echo EDGE has errors - breaking work
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.