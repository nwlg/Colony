#!/bin/bash

# Where you wish to deploy. Unfortunately the standard Agrega installation directory
# is hardcoded somewhere strange, so we'll do the actually install into 
# /home/build/deploy, and then copy out to Tomcat's webapp directory later... 
export WEBAPPS_DIR=/home/build/deploy

# Contains all the agrega modules minus the support (soporte) modules
MODULELISTFILE=common/modules.list

while read MODULE; do

	# Move to each directory in turn, and create the shared link
	echo "Deploying module $MODULE..."

	pushd ../agrega/$MODULE
	LC_ALL=eu_ES maven deploy	
	popd

done < $MODULELISTFILE
