#!/bin/bash


javac *.java
echo exemple de commande

echo
echo "bestmatch avec une valeur numérique comme graine et n=5 "
java BestMatches 5 4 ../data/reads-TRG.fasta ../data/TRGV.fasta

echo 
echo "bestmatch avec une graine ####-#### et n=5 "
java BestMatches 5 "####-####" ../data/reads-TRG.fasta ../data/TRGV.fasta

echo
echo "VJ-discover avec une valeur numérique comme graine"
java VJDiscover 4 ../data/reads-TRG.fasta ../data/TRGV.fasta ../data/TRGJ.fasta

echo
echo "VJ-discover avec une ##-###### comme graine"
java VJDiscover "##-######" ../data/reads-TRG.fasta ../data/TRGV.fasta ../data/TRGJ.fasta


cat ReponsesQuestions.txt
$SHELL