#!/bin/sh

# Find each project in turn, and update the Maven 1 repository URLs since they have
# moved and Maven 1 doesn't understand HTTP 301 responses...

for PROJECT in `find . -maxdepth 2 -name 'project.properties'`; do

        # Some status...
        echo "Updating project file $PROJECT"

        # Rename the orignal file so we still have it for reference
        cp $PROJECT $PROJECT.orig

        # Append the maven.repo line
        echo "" >> $PROJECT
        echo "# MCA: change Maven 1 repository URL due to obsolesence" >> $PROJECT
        echo "maven.repo.remote=http://mirrors.ibiblio.org/pub/mirrors/maven,http://www.ibiblio.org/maven" >> $PROJECT
done

