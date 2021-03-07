package com.cg;

public class StudentScore {
	private IDatabase iDatabaseImpl;
	
	

	public IDatabase getiDatabaseImpl() {
		return iDatabaseImpl;
	}

	public void setiDatabaseImpl(IDatabase iDatabaseImpl) {
		this.iDatabaseImpl = iDatabaseImpl;
	}

	public StudentScore(IDatabase iDatabaseImpl) {
		super();
		this.iDatabaseImpl = iDatabaseImpl;
	}
	
	public void calculateSum(String studentId, int []scores) {
		int totalScore = 0;
		for (int score: scores) {
			totalScore += score;
		}
		iDatabaseImpl.updateScores(studentId, totalScore);
	}

}
