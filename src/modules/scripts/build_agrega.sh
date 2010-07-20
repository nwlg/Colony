#!/bin/bash -

# ----------
#  Variables
# ----------

# Contains all the agrega modules minus the support (soporte) modules
MODULELISTFILE=common/modules.list

# Contains the agrega support modules
SUPPMODULELISTFILE=common/support-modules.list

# Contains the agrega modules to be bootstrapped
BMODULELISTFILE=common/bootstrap-modules.list

# Directory prefix for agrega modules
AGREGAPREFIX=../agrega

# ----------
#  Functions
# ----------

#
# maven_foreach()
#
#       Invoke a maven goal for each module in a list file
#
#         $1 -- Module path prefix (to prepend to each module)
#         $2 -- Module list file
#         $3 -- Maven args
#

maven_foreach() {
        # Move to each directory in turn, and invoke maven
        while read MODULE; do

                echo "Running \"maven $3\" for module $MODULE"
                pushd $1/$MODULE

                LC_ALL=eu_ES maven $3 # Set Spanish locale for the
                                      # maven launch to deal with
                                      # encoding map errors

                test $? -ne 0 && exit # Exit on maven error
                popd

        done < $2
}

# ----------
#  Main Section
# ----------

#
# Stage-I: Bootstrap
#

# Invoke "maven bootstrap" for each module to be bootstrapped
maven_foreach "$AGREGAPREFIX" "$BMODULELISTFILE" "bootstrap"

# Change the extension for broken WSDL -- See BUILD.txt for details
test -e ../wsdl/SrvBuscarFederadaService.wsdl && \
    mv ../wsdl/SrvBuscarFederadaService.wsdl{,.broken}

#
# Stage-II: Build the support modules.  Fix and copy SQL files.
#

# Invoke "maven jar:install" for each support module
maven_foreach "$AGREGAPREFIX" "$SUPPMODULELISTFILE" \
    "-Dmaven.test.skip jar:install"

#
# Stage-III: Build all modules but the support
#

# Invoke maven for each module
maven_foreach "$AGREGAPREFIX" "$MODULELISTFILE" "-Dmaven.test.skip"

# Create sql_schema directory if it does not exist
test ! -d ../sql_schema && mkdir ../sql_schema

echo -e "\nCopying schema SQL files..."

#
# Copy the required agrega schema SQL files (generated and others) to
# ../sql_schema.  We prepend the extracted module name to the target
# file name.
#
find "$AGREGAPREFIX" -name '*create.sql' -printf "%h %f\n" |
    while read prefix sqlfile; do

        # Extract the module name
        module=${prefix#../agrega/}
        module=${module%%/*}

        # Copy to ../sql_schema
        cp $prefix/$sqlfile ../sql_schema/${module}_${sqlfile}
    done
