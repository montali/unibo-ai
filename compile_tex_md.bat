REN https://ss64.com/nt/for_cmd.html
REM https://stackoverflow.com/a/5274061/2347196
REM dir . /b/s | find ".tex.md"

SETLOCAL DISABLEDELAYEDEXPANSION
for /F "usebackq delims=" %%F in (`dir . /b/s ^| find ".tex.md"`) do (
    set "dir=%%~pF"
    SET "src=%%~nxF"
    SETLOCAL ENABLEDELAYEDEXPANSION
    SET "dest=!src:.tex.md=.md!"
    echo "!dir!" "!src!" "!dest!"
    cd "!dir!"
    python3 -m readme2tex --readme "!src!" --nocdn --output "!dest!"
    ENDLOCAL
)
ENDLOCAL