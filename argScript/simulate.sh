#!/bin/bash

jarlocation=$1
all_pgraph=(0.1 0.2 0.3)
all_pmalicious=(0.15 0.30 0.45)
all_ptxdistribution=(0.01 0.05 0.10)
all_numrounds=(10 20)

for p_graph in "${all_pgraph[@]}"
do
	for p_malicious in "${all_pmalicious[@]}"
	do
		for p_txDist in "${all_ptxdistribution[@]}"
		do
			for numRounds in "${all_numrounds[@]}"
			do
			java -jar $jarlocation $p_graph $p_malicious $p_txDist $numRounds
			done
		done
	done
done




