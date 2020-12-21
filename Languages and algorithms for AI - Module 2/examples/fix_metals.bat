REM Script to fix Metals for VS Code if it happens an error like this:
REM 2020.12.14 17:46:37 ERROR sbt command failed: "C:\Program Files (x86)\sbt\bin\sbt" -Dbloop.export-jar-classifiers=sources bloopInstall

sbt -Dbloop.export-jar-classifiers=sources bloopInstall

REM Or with the absolute path: "C:\Program Files (x86)\sbt\bin\sbt" -Dbloop.export-jar-classifiers=sources bloopInstall