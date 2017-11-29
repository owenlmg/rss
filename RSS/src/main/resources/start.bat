
set CLASSPATH=%JAVA_HOME%/lib
set JAVA=%JAVA_HOME%/bin/java

set CLASSPATH=%CLASSPATH%;../conf
set JAVA_OPTIONS=-Djava.ext.dirs="../lib"

"%JAVA%" -Dfile.encoding=utf-8 -Xms512m -Xmx1024m -classpath "%CLASSPATH%" %JAVA_OPTIONS% com.lmg.rss.App

pause