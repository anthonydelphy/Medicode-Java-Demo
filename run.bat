pushd .\out\
java -cp ..\dependencies\gson-2.8.9.jar;. --module-path %JAVA_FX_HOME% --add-modules javafx.controls Main
popd