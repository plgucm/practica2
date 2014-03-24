#!/bin/bash
echo "<=====================================>" &&
echo "Compilando Java CC..." &&
echo "<=====================================>" &&
cd ./src/javacc/asint/ &&
./prod.sh &&
echo "<=====================================>" &&
echo "Compilando CUP..." &&
echo "<=====================================>" &&
cd ../../cup/asint/ &&
./prod.sh
