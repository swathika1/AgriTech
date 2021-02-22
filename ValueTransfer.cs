using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class ValueTransfer : MonoBehaviour
{
	public string type;
	public GameObject WheatTypeInputField;
	public string NutrientValue;
	public GameObject NutrientInputField;
	public GameObject FertilizerTextDisplay;

	public string MoistureValue;
	public GameObject MoistureInputField;
	public GameObject WaterTextDisplay;

	public double n;
	public double m;

	public string sn;
	public string sm;

	public void StoreValues(){
		NutrientValue=NutrientInputField.GetComponent<Text>().text;
		
		MoistureValue=MoistureInputField.GetComponent<Text>().text;
		
		n=double.Parse(NutrientValue);
		m=double.Parse(MoistureValue);
		
		//sn=n.ToString();
		//sm=m.ToString();

		type=WheatTypeInputField.GetComponent<Text>().text;

		if (type == "EMERGENCE"){
			
			if(n>85){
				FertilizerTextDisplay.GetComponent<Text>().text="SUFFICIENT NUTRIENT IN CROPS";
			}
			else{
			n=((-0.224)*n)+44.03;
			sn=n.ToString();
			FertilizerTextDisplay.GetComponent<Text>().text=sn;
			}
			if(m>=0.9){
				WaterTextDisplay.GetComponent<Text>().text="SUFFICIENT WATER IN CROPS";
			}
			else{
				m=0.9-m;
				sm=m.ToString();
				WaterTextDisplay.GetComponent<Text>().text=sm;
			}
		

}//forDormancy

else if (type == "TILLERING"){
		
			if(n>85){
				FertilizerTextDisplay.GetComponent<Text>().text="SUFFICIENT NUTRIENT IN CROPS";
			}
			else{
			n=((-0.224)*n)+44.03;
			sn=n.ToString();
			FertilizerTextDisplay.GetComponent<Text>().text=sn;
			}
			if(m>=3.25){
				WaterTextDisplay.GetComponent<Text>().text="SUFFICIENT WATER IN CROPS";
			}
			else{
				m=3.25-m;
				sm=m.ToString();
				WaterTextDisplay.GetComponent<Text>().text=sm;
			}
		

}//forTILLERING

else if (type == "BOOTING"){
		
			if(n>45){
				FertilizerTextDisplay.GetComponent<Text>().text="SUFFICIENT NUTRIENT IN CROPS";
			}
			else{
			n=((-0.224)*n)+44.03;
			sn=n.ToString();
			FertilizerTextDisplay.GetComponent<Text>().text=sn;
			}

			if(m>=5.3){
				WaterTextDisplay.GetComponent<Text>().text="SUFFICIENT WATER IN CROPS";
			}
			else{
				m=5.3-m;
				sm=m.ToString();
				WaterTextDisplay.GetComponent<Text>().text=sm;
			}
		

}//forBOOTING

else if (type == "HEADING AND FLOWERING"){
		
			if(n>45){
				FertilizerTextDisplay.GetComponent<Text>().text="SUFFICIENT NUTRIENT IN CROPS";
			}
			else{
			n=((-0.224)*n)+44.03;
			sn=n.ToString();
			FertilizerTextDisplay.GetComponent<Text>().text=sn;
			}

			if(m>=5.6){
				WaterTextDisplay.GetComponent<Text>().text="SUFFICIENT WATER IN CROPS";
			}
			else{
				m=5.6-m;
				sm=m.ToString();
				WaterTextDisplay.GetComponent<Text>().text=sm;
			}
		

}//forHEADING AND FLOWERING

else if (type == "RIPENING"){
		
			if(n>45){
				FertilizerTextDisplay.GetComponent<Text>().text="SUFFICIENT NUTRIENT IN CROPS";
			}
			else{
			n=((-0.224)*n)+44.03;
			sn=n.ToString();
			FertilizerTextDisplay.GetComponent<Text>().text=sn;
			}
			if(m>=3.0){
				WaterTextDisplay.GetComponent<Text>().text="SUFFICIENT WATER IN CROPS";
			}
			else{
				m=3.0-m;
				sm=m.ToString();
				WaterTextDisplay.GetComponent<Text>().text=sm;
			}
		

}//forRIPENING

		else{
		FertilizerTextDisplay.GetComponent<Text>().text="";
		WaterTextDisplay.GetComponent<Text>().text="";
}
}
}
