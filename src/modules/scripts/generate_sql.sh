#!/bin/sh

#
# Extract just the parts that are required to create a fresh database from the AndroMDA-generated SQL
#
# The generated file lives in <module>/target/sql/schema-create.sql for each module; however it also
# contains additional detail for dropping the schema at the start which will blow out any transactions!
# Hence we look through each file, extract everything beginning from the first "create" line, and store 
# this in a separate generated_sql directory with the same name as the module. Phew! 
#

MODULES="\
	AdminUsuarios \
	agregadorRSS \
	auditoria \
	buscador \
	buscar \
	catalogacion \
	catalogadorWeb \
	contenidosportal \
	DRI \
	empaquetadorbasico \
	entregar \
	fuentestaxonomicas \
	gestorflujo \
	indexador \
	localizador \
	modificador \
	ModificadorWeb \
	oaipmh \
	planificador \
	portaladministracion \
	PortalEmpaquetador \
	publicacion \
	TaggingWeb \
	validador \
	valoracion \
	visualizador \
	visualizadorcontenidos \
	"

# Make an output directory here
mkdir generated_sql

for THISMODULE in $MODULES; do

	# Progress...
	echo "Processing module $THISMODULE..."

	# Find the AndroMDA-generated files for this module
	FILE="./$THISMODULE/target/sql/schema-create.sql"

	# Check that the file isn't empty first...
	FILETAIL=`tail -n 10 $FILE`
	if [ ! "$FILETAIL" == "" ]; then 

		# Copy from the starting line to the end of the file into the
		# generated_sql directory 
		cp $FILE ./generated_sql/$THISMODULE-create.sql
	fi

done;	
