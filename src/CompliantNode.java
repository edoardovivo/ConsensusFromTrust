package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* CompliantNode refers to a node that follows the rules (not malicious)*/
public class CompliantNode implements Node {
	
	double p_graph;
	double p_malicious;
	double p_txDistribution; 
	int numRounds;
	boolean[] followees;
	Set<Transaction> pendingTransactions;
	Set<Candidate> candidates;
    
	public CompliantNode(double p_graph, double p_malicious, double p_txDistribution, int numRounds) {
        // IMPLEMENT THIS
		this.p_graph = p_graph;
		this.p_malicious = p_malicious;
		this.p_txDistribution = p_txDistribution;
		this.numRounds = numRounds;
    }

    public void setFollowees(boolean[] followees) {
        // IMPLEMENT THIS
    	this.followees = followees;
    }

    public void setPendingTransaction(Set<Transaction> pendingTransactions) {
        // IMPLEMENT THIS
    	this.pendingTransactions = pendingTransactions;
    }

    public Set<Transaction> sendToFollowers() {
    	
    	if (candidates != null) {
    		Set<Transaction> txCandidates = new HashSet<Transaction>();
    		for (Candidate candidate : candidates) {
	        	txCandidates.add(candidate.tx);
	        }
    		Set<Transaction> txIntersect = new HashSet<Transaction>();
    		Set<Transaction> txUnion = new HashSet<Transaction>();
    		txIntersect = pendingTransactions;
    		txIntersect.retainAll(txCandidates);
    		txUnion = pendingTransactions;
    		txUnion.addAll(txCandidates);
    		if (txIntersect.size() > 0) {
    			//System.out.println("Intersection");
    			pendingTransactions.removeAll(txCandidates);
    			return txCandidates;
    		}
    		else {
    			//System.out.println("Union");
    			pendingTransactions.addAll(txCandidates);
    			return pendingTransactions; 
    		}
    	}
    	else {
    
    		return pendingTransactions;
    	}
    }

    public void receiveFromFollowees(Set<Candidate> candidates) {
        // IMPLEMENT THIS
    	this.candidates = candidates;
    }
    	
}
