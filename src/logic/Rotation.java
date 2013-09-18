package logic;

import logic.entities.Punkt;

public class Rotation {
	private Rotation() {}
	/**   
	 * Rotiert den Punkt <i>p</i> um <i>rad</i> Radiant.
	 * @param rad Der Winkel um den gedreht wird.
	 * @param p Der Punkt der gedreht wird.
	 * @return Die Koordinaten des neuen Punktes.
	 * @see logic.entities.Punkt
	 * @deprecated
	 */
    public static double[] rotateXY(double rad, Punkt p){
    	
    	double cos = StrictMath.cos(rad + p.getRad());
    	double sin = StrictMath.sin(rad + p.getRad());
        
    	double[][] xy = {{cos, -sin, 0, 0},
        				 {sin, cos, 0, 0},
        				 {0, 0, 1, 0},
        				 {0, 0, 0, 1}};
    	
    	double[] cord = {p.getX(), p.getY(), p.getZ(), p.getW()};
    	double[] cordAtm = {0,0,0,0};

    	// Matrix xy multipliziert mit Vektor cord
    	for(int i = 0; i < 4; i++){
    		double temp = 0;
    		for(int j = 0; j < 4; j++){
    			temp = temp + xy[i][j] * cord[j];
    		}
    		cordAtm[i] = temp;
    		System.out.println(temp);
    	}
    	
		return cordAtm;
    }
}

