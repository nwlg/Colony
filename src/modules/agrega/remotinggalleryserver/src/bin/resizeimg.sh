#!/bin/bash

# constantes
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
#echo "Copio el fichero [$2] en [$UPLOADS_PATH/$3/$1/]"
#cp $2 $UPLOADS_PATH/$3/$1/
echo "Convirtiendo la imagen $2 al formato JPG en $UPLOADS_PATH/$3/$4/$1_captured.jpg ..." `date`
convert "$2" "$UPLOADS_PATH/$3/$4/$1_captured.jpg"
echo "[OK] Imagen convertida correctamente"  `date`

echo "Generando imagen reducida $UPLOADS_PATH/$3/$4/$1.png ..." `date`
convert -resize $IMAGE_FINAL_SIZE "$UPLOADS_PATH/$3/$4/$1_captured.jpg" "$UPLOADS_PATH/$3/$4/$1.png"
echo "[OK] Imagen reducida generada correctamente" `date`
