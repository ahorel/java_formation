
//Ecrire une méthode permettant de remplacer les espaces par %20

//On modifie la string en commencant par la fin car il y a un extra buffer a la fin ce qui nous permet de changer
// les caractères sans se demander ce qu'on écrase

//2 scans : 
//1 scan pour compter le nombre d'espaces. En multipliant par trois ce nombre, on obtient la longueur à utiliser.
//1 scan en ordre inverse pour editer la string et remplacer les espaces par %20
public class Urlify {

	void replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0, index, i = 0;
		for(i=0;i<trueLength;i++) {
			if (str[i] == ' ') {
				spaceCount ++;
			}
		}
		index = trueLength + spaceCount * 2;
		if(trueLength < str.length) str[trueLength] = '\0';
		for(i = trueLength - 1; i >= 0; i --) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			}
			else {
				str[index - 1] = str[i];
				index --;
			}
		}
	}
	
	
}
