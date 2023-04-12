#!/bin/sh

[ ! -e "$JAVA_HOME/bin/java" ] && JAVA_HOME=/usr/local/java
[ ! -e "$JAVA_HOME/bin/java" ] && JAVA_HOME=/opt/java
[ ! -e "$JAVA_HOME/bin/java" ] && JAVA_HOME=/usr/java
[ ! -e "$JAVA_HOME/bin/java" ] && unset JAVA_HOME

export DATE_STR=`date "+%Y%m%d%H%M%S"`
export BASE_DIR=`cd $(dirname "$0") && pwd`

cd $BASE_DIR

# ----------------------- Set APP environment variables ----------------------------

APP_NAME="sender"
APP_MAIN=$APP_NAME.jar

JAVA_OPT="-Djava.net.preferIPv4Stack=true"
JAVA_OPT="${JAVA_OPT} -server -Xms4g -Xmx4g -Xmn256m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=320m"
JAVA_OPT="${JAVA_OPT} -XX:-OmitStackTraceInFastThrow -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${BASE_DIR}/logs/heapdump-$DATE_STR.hprof"
JAVA_OPT="${JAVA_OPT} -XX:-UseLargePages"
JAVA_OPT="${JAVA_OPT} -Djava.io.tmpdir=${BASE_DIR}/work"
JAVA_OPT="${JAVA_OPT} -Djava.ext.dirs=${JAVA_HOME}/jre/lib/ext:${JAVA_HOME}/lib/ext"
JAVA_OPT="${JAVA_OPT} -Xloggc:${BASE_DIR}/logs/gc/gc-$DATE_STR.log -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=100M"
#JAVA_OPT="${JAVA_OPT} -Ddruid.mysql.usePingMethod=false"
#JAVA_OPT="${JAVA_OPT} -agentlib:jdwp=transport=dt_socket,address=62589,server=y,suspend=n"

# --spring.config.location=xx/xx/xx/application.yml
if [ -f "$LAIHU_SPRING_CONFIG_LOCATION" ] ; then
  JAVA_OPT="${JAVA_OPT} --spring.config.location=$LAIHU_SPRING_CONFIG_LOCATION"
fi

mkdir work logs logs/gc > /dev/null 2>&1

# ----------------- Usage: sh startup.sh start|stop|restart|status --------------------

PID=`ps x | grep $APP_MAIN | grep -v grep | awk '{print $1}'`
PID=`expr $PID + 0`

case $1 in
# ------ start ------
start)
  if [ $PID -le 1 ] ; then
      echo "[ INFO] $APP_NAME is starting..."
      nohup $JAVA_HOME/bin/java -jar $JAVA_OPT $APP_MAIN > nohup.out 2>&1 &
      sleep 3
      PID=`ps x | grep $APP_MAIN | grep -v grep | awk '{print $1}'`
      PID=`expr $PID + 0`
      if [ $PID -le 1 ] ; then
          echo "[ERROR] $APP_NAME starts failed!"
      else
          echo "[ INFO] $APP_NAME starts successfully. PID: $PID"
          netstat -tnlp | grep java | grep $PID
      fi
  else
      echo "[ WARN] $APP_NAME has already started, it's running... PID: $PID"
    netstat -tnlp | grep java | grep $PID
  fi
  exit 0
  ;;
# ------ stop ------
stop)
  if [ $PID -le 1 ] ; then
      echo "[ INFO] $APP_NAME has already stopped!"
  else
      kill $PID
      sleep 2
      PID=`ps x | grep $APP_MAIN | grep -v grep | awk '{print $1}'`
      PID=`expr $PID + 0`
      if [ $PID -le 1 ] ; then
          echo "[ INFO] $APP_NAME stops successfully"
      else
          echo "[ERROR] $APP_NAME stops failed! Please try agin. PID: $PID"
      fi
  fi
  exit 0
  ;;
# ------ restart ------
restart)
  sh $0 stop
  sh $0 start
  ;;
# ------ status ------
status)
  if [ $PID -le 1 ] ; then
      echo "[ WARN] $APP_NAME has already stopped!"
  else
      echo "[ INFO] $APP_NAME is running... PID: $PID"
      netstat -tnlp | grep java | grep $PID
  fi
  ;;
# ------ others ------
*)
  echo "Usage: sh start.sh start|stop|restart|status|version"
esac

exit 0
