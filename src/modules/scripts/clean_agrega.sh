#!/bin/bash

# Contains all the agrega modules minus the support (soporte) modules
MODULELISTFILE=common/modules.list

# Clean up all of the projects, executing "maven clean" for each one and clearing out
# any remaining AndroMDA log files

while read MODULE; do

	# Move to each directory in turn, and create the shared link
	echo "Cleaning module $MODULE..."

	pushd ../agrega/$MODULE
	rm -f andromda*.log
	LC_ALL=eu_ES maven clean	
	popd

done < $MODULELISTFILE
