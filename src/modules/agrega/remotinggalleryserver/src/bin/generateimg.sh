#!/bin/bash

# constantes
videoDelayCaptureInSeconds=3;
UPLOADS_PATH=uploads/galeriaimg;
IMAGE_FINAL_SIZE=100x100;

echo "Parametros = [$1] [$2] [$3] [$4]"

if test -z "$1"
then
        echo "Falta el primer parametro obligatorio de la llamada"
        exit
fi

if test -z "$2"
then
        echo "Falta el segundo parametro obligatorio de la llamada"
        exit
fi

if test -z "$3"
then
        echo "Falta el tercer parametro obligatorio de la llamada"
        exit
fi

if test -z "$4"
then
        echo "Falta el tercer parametro obligatorio de la llamada"
        exit
fi

mkdir -p "$UPLOADS_PATH/$3/$4/"
fileType=`file -bi "$2" | awk -F'/' '{print $1}'`
echo "FileType is: '$fileType'" 

if [ $fileType == "image" ]
then
	echo "Convirtiendo la imagen $2 al formato JPG en $UPLOADS_PATH/$3/$4/$1_captured.jpg ..." `date`
	convert "$2" "$UPLOADS_PATH/$3/$4/$1_captured.jpg"
	echo "[OK] Imagen convertida correctamente"  `date`
elif [ $fileType == "video" ]
then
	echo "Capturando del video a los $videoDelayCaptureInSeconds segundos a una imagen JPG..." `date` 
	ffmpeg -i "$2" -y -ss $videoDelayCaptureInSeconds -t 0.01 -f mjpeg "$UPLOADS_PATH/$3/$4/$1_captured.jpg"
	echo "[OK] Video capturado correctamente" `date`
else
	echo "Capturando el fichero $2 desde un navegador..." `date`
	Xvfb :1 -fp /usr/share/fonts/X11/misc -screen 0 800x600x24 -fbdir /var/tmp &
	DISPLAY=:1 iceweasel -no-remote file:"$2" &
	sleep 5
	DISPLAY=:1 import -window root "$UPLOADS_PATH/$3/$4/$1_captured.jpg"
	killall firefox-bin
	sleep 1
	killall firefox
	sleep 1
	killall run-mozilla
	killall run-mozilla.sh
	killall Xvfb
	echo "[OK] Ventana de navegador capturada correctamente" `date`
fi

echo "Generando imagen reducida $UPLOADS_PATH/$3/$4/$1.png ..." `date`
convert -resize $IMAGE_FINAL_SIZE "$UPLOADS_PATH/$3/$4/$1_captured.jpg" "$UPLOADS_PATH/$3/$4/$1.png"
echo "[OK] Imagen reducida generada correctamente" `date`
