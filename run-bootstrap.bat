REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=shodrone.app.bootstrap\target\shodrone.app.bootstrap-0.1.0.jar;shodrone.app.bootstrap\target\dependency\*;

REM call the java VM, e.g,
java --add-opens java.base/java.lang=ALL-UNNAMED -cp %BASE_CP% eapli.base.app.bootstrap.BaseBootstrap