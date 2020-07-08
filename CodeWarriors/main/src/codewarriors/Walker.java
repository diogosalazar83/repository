package codewarriors;

class Walker {

	public static int[] solve(int a, int b, int c, int alpha, int beta, int gamma) {
		// starting from 0,0
		//converting alpha from degree to radian
		double alphaRadian = Math.toRadians(alpha);
		//getting first coordinate
		double currentPointX = Math.cos(alphaRadian)*a;
		double currentPointY = Math.sin(alphaRadian)*a;
		
		//converting beta from degree to radian
		double betaRadian = Math.toRadians(beta+90);
		//updating coordinates
		currentPointX += Math.cos(betaRadian)*b;
		currentPointY += Math.sin(betaRadian)*b;
		
		//converting gamma from degree to radian
		double gammaRadian = Math.toRadians(gamma+180);
		//updating coordinates
		currentPointX += Math.cos(gammaRadian)*c;
		currentPointY += Math.sin(gammaRadian)*c;
		
		double angle = Math.atan2(currentPointY, currentPointX);
		
		int finalHypotenuse = (int) Math.rint(Math.hypot(currentPointX, currentPointY));
		double degreeAngle = Math.toDegrees(angle);
		int integerAngle = getDegree(degreeAngle);
		int minuteAngle = getMinute(degreeAngle);
		int secondAngle = getSecond(degreeAngle);
		int[] result = new int[] {finalHypotenuse, integerAngle, minuteAngle, secondAngle};
		return result;
	}
	
	private static int getSecond(double degreeAngle) {
		double fraction = degreeAngle % 1;
		double minutes = fraction * 60;
		double fractionOfMinutes = minutes %1;
		double calculation = fractionOfMinutes * 60;
		double decimal = calculation % 1;
		return (int) (calculation - decimal);
	}



	private static int getMinute(double degreeAngle) {
		double fraction = degreeAngle % 1;
		double calculation = fraction * 60;
		double decimal = calculation % 1;
		return (int) (calculation - decimal);
	}



	private static int getDegree(double degreeAngle) {
		double fraction = degreeAngle % 1;
		return (int) Math.rint(degreeAngle-fraction);
	}
}
