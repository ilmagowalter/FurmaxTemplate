cd ".\src\app\swagger\generation"
del /q "..\.swagger-codegen\"
del /q "..\api\"
del /q "..\model\"
del /q "..\..\swagger\"
java -jar .\swagger-codegen-cli-2.4.15.jar generate -i ..\..\..\..\..\BE\src\main\resources\it\furmax\template\swagger\swagger.yaml -l typescript-angular -c .\config.json -o ..\..\swagger\
